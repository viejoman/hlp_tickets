package corp.galvan.hlp.ticket.service;

import corp.galvan.hlp.ticket.domain.HistorialTicket;
import corp.galvan.hlp.ticket.enums.Grupos;
import corp.galvan.hlp.ticket.query.*;
import corp.galvan.hlp.ticket.domain.Ticket;
import corp.galvan.hlp.ticket.model.TipoServicio;
import corp.galvan.hlp.ticket.model.Usuario;
import corp.galvan.hlp.ticket.repositories.HistorialTicketRepository;
import corp.galvan.hlp.ticket.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @PersistenceContext
    private EntityManager _entityManager;

    private TicketRepository _ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository p__ticketRepository) {
        this._ticketRepository = p__ticketRepository;
    }


    @Override
    public List<Ticket> listAll() {
        List<Ticket> _inhibidores = new ArrayList<>();
        _ticketRepository.findAll().forEach(_inhibidores::add);
        return _inhibidores;
    }

    @Override
    public Ticket getById(Long id) {
        return _ticketRepository.findById(id).orElse(null);
    }

    @Override
    public Ticket saveOrUpdate(Ticket model) {
        model = _ticketRepository.save(model);
        return model;
    }

    @Override
    public void delete(Long id) {
        _ticketRepository.deleteById(id);
    }

    @Override
    public List<Ticket> getTicketByIdUsuario(Long p_IdGrupo, Long p_IdUsuario) {

        /*StoredProcedureQuery q = _entityManager.createNamedStoredProcedureQuery("obtenerTicketByIdUsuario");
        q.setParameter("idgrupo", p_IdGrupo);
        q.setParameter("idusuario", p_IdUsuario);
        List<Ticket> _listMenuTemp = q.getResultList();

        return _listMenuTemp;*/

        List<Ticket> _listTicket = new ArrayList<>();

        String _sqlString = ConsultaSQL._BUSCAR_TICKETS_BY_IDUSUARIO;

        if (p_IdGrupo.equals(Grupos._SISTEMAS)) {
            _sqlString = ConsultaSQL._BUSCAR_TICKETS_BY_IDUSUARIOSIS;
        }

        Query q = _entityManager.createNativeQuery(_sqlString, "TicketHLPMapping");
        q.setParameter("p_idusuario", p_IdUsuario);
        List<Object[]> _listResultQuery = q.getResultList();

        if (!_listResultQuery.isEmpty()) {

            for (Object[] _resultObject : _listResultQuery) {
                Ticket _ticketAux = (Ticket)_resultObject[0];
                TipoServicio _tipoServicioAux = (TipoServicio)_resultObject[1];
                Usuario _usuarioAux = (Usuario)_resultObject[2];
                _ticketAux.setTiposerviciodata(_tipoServicioAux);
                _ticketAux.setUsuariodata(_usuarioAux);
                _listTicket.add(_ticketAux);
            }
            
        }

        return _listTicket;

    }


    @Override
    public List<Ticket> getListTicketUsuarioByIdEstado(Long p_IdGrupo, Long p_IdUsuario, Long p_IdEstatus) {

        /*StoredProcedureQuery q = _entityManager.createNamedStoredProcedureQuery("obtenerTicketByIdUsuario");
        q.setParameter("idgrupo", p_IdGrupo);
        q.setParameter("idusuario", p_IdUsuario);
        List<Ticket> _listMenuTemp = q.getResultList();

        return _listMenuTemp;*/

        List<Ticket> _listTicket = new ArrayList<>();

        String _sqlString = ConsultaSQL._BUSCAR_TICKETS_BY_IDUSUARIO;

        if (p_IdGrupo.equals(Grupos._SISTEMAS)) {
            _sqlString = ConsultaSQL._BUSCAR_TICKETS_BY_IDUSUARIOSIS;
        }

        Query q = _entityManager.createNativeQuery(_sqlString, "TicketHLPMapping");
        q.setParameter("p_idusuario", p_IdUsuario);
        q.setParameter("p_idestatus", p_IdEstatus);
        List<Object[]> _listResultQuery = q.getResultList();

        if (!_listResultQuery.isEmpty()) {

            for (Object[] _resultObject : _listResultQuery) {
                Ticket _ticketAux = (Ticket)_resultObject[0];
                TipoServicio _tipoServicioAux = (TipoServicio)_resultObject[1];
                Usuario _usuarioAux = (Usuario)_resultObject[2];
                _ticketAux.setTiposerviciodata(_tipoServicioAux);
                _ticketAux.setUsuariodata(_usuarioAux);
                _listTicket.add(_ticketAux);
            }

        }

        return _listTicket;

    }

    @Override
    public List<Ticket> getListTicketCanceladosCerradosByIdUsuario(Long p_IdGrupo, Long p_IdUsuario) {

        /*StoredProcedureQuery q = _entityManager.createNamedStoredProcedureQuery("obtenerTicketByIdUsuario");
        q.setParameter("idgrupo", p_IdGrupo);
        q.setParameter("idusuario", p_IdUsuario);
        List<Ticket> _listMenuTemp = q.getResultList();

        return _listMenuTemp;*/

        List<Ticket> _listTicket = new ArrayList<>();

        String _sqlString = ConsultaSQL._BUSCAR_TICKETS_CANCELADOS_Y_CERRADOS_BY_IDUSUARIO;

        if (p_IdGrupo.equals(Grupos._SISTEMAS)) {
            _sqlString = ConsultaSQL._BUSCAR_TICKETS_CANCELADOS_Y_CERRADOS_BY_IDUSUARIOSIS;
        }

        Query q = _entityManager.createNativeQuery(_sqlString, "TicketHLPMapping");
        q.setParameter("p_idusuario", p_IdUsuario);
        List<Object[]> _listResultQuery = q.getResultList();

        if (!_listResultQuery.isEmpty()) {

            for (Object[] _resultObject : _listResultQuery) {
                Ticket _ticketAux = (Ticket)_resultObject[0];
                TipoServicio _tipoServicioAux = (TipoServicio)_resultObject[1];
                Usuario _usuarioAux = (Usuario)_resultObject[2];
                _ticketAux.setTiposerviciodata(_tipoServicioAux);
                _ticketAux.setUsuariodata(_usuarioAux);
                _listTicket.add(_ticketAux);
            }

        }

        return _listTicket;

    }

    /*
    @Override
    public List<Ticket> getListTicketUsuarioByIdEstado(Long p__idusuario, Long p_idstado) {

        List<Ticket> _listTicket = new ArrayList<>();

        String _sqlString = ConsultaSQL._BUSCAR_NEW_TICKETS_BY_IDUSUARIO;

        Query q = _entityManager.createNativeQuery(_sqlString, "TicketHLPMapping");
        q.setParameter("p_idusuario", p__idusuario);
        List<Object[]> _listResultQuery = q.getResultList();

        if (!_listResultQuery.isEmpty()) {
            for (Object[] _resultObject : _listResultQuery) {
                Ticket _ticketAux = (Ticket)_resultObject[0];
                TipoServicio _tipoServicioAux = (TipoServicio)_resultObject[1];
                Usuario _usuarioAux = (Usuario)_resultObject[2];
                _ticketAux.setTiposerviciodata(_tipoServicioAux);
                _ticketAux.setUsuariodata(_usuarioAux);
                _listTicket.add(_ticketAux);
            }
        }

        return _listTicket;

    }
    */

}
