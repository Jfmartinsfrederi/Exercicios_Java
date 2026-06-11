package ticket;

import dto.EntryTicketDto;
import dto.ExitTicketDto;

import java.util.Optional;

public interface TicketDao {
    void save(EntryTicketDto entryTicketDto);
    Optional<EntryTicketDto> findOpenTicket(String id);
    void updateExit(ExitTicketDto exitTicketDto);
}
