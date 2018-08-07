
package corp.galvan.hlp.ticket.repositories;

import corp.galvan.hlp.ticket.domain.AdjuntoDoctoTicket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdjuntoDoctoTicketRepository extends CrudRepository<AdjuntoDoctoTicket, Long> {

    List<AdjuntoDoctoTicket> findByIdticket(Long idticket);

}