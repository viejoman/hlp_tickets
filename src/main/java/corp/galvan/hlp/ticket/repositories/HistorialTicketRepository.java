package corp.galvan.hlp.ticket.repositories;

import corp.galvan.hlp.ticket.domain.HistorialTicket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistorialTicketRepository extends CrudRepository<HistorialTicket, Long> {

    List<HistorialTicket> findByIdticket(Long idticket);

}
