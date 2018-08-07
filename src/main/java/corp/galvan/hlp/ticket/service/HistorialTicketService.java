package corp.galvan.hlp.ticket.service;

import corp.galvan.hlp.ticket.domain.HistorialTicket;

import java.util.List;

public interface HistorialTicketService {

    List<HistorialTicket> listAll();

    HistorialTicket getById(Long id);

    HistorialTicket saveOrUpdate(HistorialTicket model);

    void delete(Long id);

    List<HistorialTicket> findByIdticket(Long idticket);

    List<HistorialTicket> getHistorialTicketByIdticket(Long p_Idticket);

    List<HistorialTicket> getAllHistorialTicket();

}
