package corp.galvan.hlp.ticket.service;

import corp.galvan.hlp.ticket.domain.AdjuntoDoctoTicket;

import java.util.List;

public interface AdjuntoDoctoTicketService {

    List<AdjuntoDoctoTicket> listAll();

    AdjuntoDoctoTicket getById(Long id);

    AdjuntoDoctoTicket saveOrUpdate(AdjuntoDoctoTicket model);

    void delete(Long id);

    List<AdjuntoDoctoTicket> findByIdticket(Long idticket);

}
