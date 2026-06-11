package ticket;

import customer.CustomerDao;
import dto.CustomerDto;
import dto.EntryTicketDto;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

public class RegisterEntryService {
    private final CustomerDao customerDao;
    private final TicketDao ticketDao;

    public RegisterEntryService(CustomerDao customerDao, TicketDao ticketDao) {
        this.customerDao = customerDao;
        this.ticketDao = ticketDao;
    }

    public void register(String plate) {
        Objects.requireNonNull(plate, "Plate must be not null");
        if (plate.isBlank()) throw new IllegalArgumentException("Plate must be not blank");
        Optional<CustomerDto> customerDto = customerDao.findOne(plate);
        if (customerDao.findOne(plate).isEmpty())
            throw new NoSuchElementException("Customer not found");

        Ticket ticket = new Ticket(CustomerDto.fromDto(customerDto.get()));


        ticketDao.save(new EntryTicketDto(ticket.getUuid().toString(),
                ticket.getCustomer().getPlate(),
                ticket.getEntry().toString()));


    }


}
