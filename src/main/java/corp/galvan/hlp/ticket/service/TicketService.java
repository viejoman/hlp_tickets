package corp.galvan.hlp.ticket.service;

import corp.galvan.hlp.ticket.domain.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> listAll();

    Ticket getById(Long id);

    Ticket saveOrUpdate(Ticket model);

    void delete(Long id);

    List<Ticket> getTicketByIdUsuario(Long p_IdGrupo, Long p_IdUsuario);

    List<Ticket> getListTicketUsuarioByIdEstado(Long p_IdUsurio, Long p_IdUsuario, Long p_IdEstatus);

    List<Ticket> getListTicketCanceladosCerradosByIdUsuario(Long p_IdGrupo, Long p_IdUsuario);

}
