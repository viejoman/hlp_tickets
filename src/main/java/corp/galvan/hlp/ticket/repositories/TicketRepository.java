package corp.galvan.hlp.ticket.repositories;

import corp.galvan.hlp.ticket.domain.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
