package corp.galvan.hlp.ticket.service;

import corp.galvan.hlp.ticket.domain.Ticket;
import corp.galvan.hlp.ticket.model.Sort;

import java.util.Collection;
import java.util.List;

public interface TicketService {

    List<Ticket> listAll();

    Ticket getById(Long id);

    Ticket saveOrUpdate(Ticket model);

    void delete(Long id);

    List<Ticket> getTicketByIdUsuario(Long p_IdGrupo, Long p_IdUsuario, Collection<Sort> sortList);

    List<Ticket> getListTicketUsuarioByIdEstado(Long p_IdUsurio, Long p_IdUsuario, Long p_IdEstatus, Collection<Sort> sortList);

    List<Ticket> getListTicketCanceladosCerradosByIdUsuario(Long p_IdGrupo, Long p_IdUsuario, Collection<Sort> sortList);

}
