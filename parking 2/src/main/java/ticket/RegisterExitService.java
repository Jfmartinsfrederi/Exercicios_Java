package ticket;

import costs.PeriodCostDao;
import customer.CustomerDao;
import dto.CustomerDto;
import dto.EntryTicketDto;
import dto.ExitTicketDto;
import dto.PeriodCostDto;

import java.time.LocalDateTime;
import java.util.*;

public class RegisterExitService {
    private final CustomerDao customerDao;
    private final TicketDao ticketDao;
    private final PeriodCostDao periodCostDao;


    public RegisterExitService(CustomerDao customerDao, TicketDao ticketDao, PeriodCostDao periodCostDao) {
        this.customerDao = customerDao;
        this.ticketDao = ticketDao;
        this.periodCostDao = periodCostDao;
    }

    public double register(String plate) {
        Objects.requireNonNull(plate, "Plate must be not null");
        if (plate.isBlank()) throw new IllegalArgumentException("Plate must be not blank");
        Optional<CustomerDto> customerDto = customerDao.findOne(plate);
        if (customerDto.isEmpty())
            throw new NoSuchElementException("Customer not found");
        Optional<EntryTicketDto> entryTicketDto = ticketDao.findOpenTicket(plate);

        if (entryTicketDto.isEmpty())
            throw new IllegalStateException("Ticket not found");
        Ticket ticket = new Ticket(UUID.fromString(entryTicketDto.get().id()),
                CustomerDto.fromDto(customerDto.get()),
                LocalDateTime.parse(entryTicketDto.get().entry()));

        ticket.exit();
        double fee = calculateFee(ticket.parkingDuration());
        ticketDao.updateExit(new ExitTicketDto(plate, ticket.getExit().toString(), fee));
        return fee;


    }

    private double calculateFee(int hours) {
        return calculateFee(hours, periodCostDao.findAll());
    }

    private double calculateFee(int hours, List<PeriodCostDto> periods) {

        if (hours <= 0) {
            return 0;
        }

        return periods.stream()
                .map(period -> period.hours() >= hours
                        ? period.fee()
                        : period.fee() + calculateFee(hours - period.hours(), periods))
                .min(Double::compareTo)
                .orElseThrow();
    }


}
