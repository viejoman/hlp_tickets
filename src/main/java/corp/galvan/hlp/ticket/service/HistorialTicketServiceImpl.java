package corp.galvan.hlp.ticket.service;

import corp.galvan.hlp.ticket.domain.HistorialTicket;
import corp.galvan.hlp.ticket.domain.Ticket;
import corp.galvan.hlp.ticket.model.Accion;
import corp.galvan.hlp.ticket.model.Inhibidor;
import corp.galvan.hlp.ticket.model.Usuario;
import corp.galvan.hlp.ticket.query.ConsultaSQL;
import corp.galvan.hlp.ticket.repositories.HistorialTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistorialTicketServiceImpl implements HistorialTicketService {

    @PersistenceContext
    private EntityManager _entityManager;

    private HistorialTicketRepository _historialTicketRepository;

    @Autowired
    public HistorialTicketServiceImpl(HistorialTicketRepository p__historialTicketRepository) {
        this._historialTicketRepository = p__historialTicketRepository;
    }

    @Override
    public List<HistorialTicket> listAll() {
        List<HistorialTicket> _historialTicket = new ArrayList<>();
        _historialTicketRepository.findAll().forEach(_historialTicket::add);
        return _historialTicket;
    }

    @Override
    public HistorialTicket getById(Long id) {
        return _historialTicketRepository.findById(id).orElse(null);
    }

    @Override
    public HistorialTicket saveOrUpdate(HistorialTicket model) {
        model = _historialTicketRepository.save(model);
        return model;
    }

    @Override
    public void delete(Long id) {
        _historialTicketRepository.deleteById(id);
    }

    @Override
    public List<HistorialTicket> findByIdticket(Long idticket) {
        return _historialTicketRepository.findByIdticket(idticket);
    }

    @Override
    public List<HistorialTicket> getHistorialTicketByIdticket(Long p_Idticket) {

        List<HistorialTicket> _listHistorialTicket = new ArrayList<>();

        String _sqlString = ConsultaSQL._LISTAR_HISTORIAL_TICKETS_BY_IDTICKET;

        Query q = _entityManager.createNativeQuery(_sqlString, "HistorialTicketHLPMapping");
        q.setParameter("p_idticket", p_Idticket);
        List<Object[]> _listResultQuery = q.getResultList();

        if (!_listResultQuery.isEmpty()) {

            for (Object[] _resultObject : _listResultQuery) {
                HistorialTicket _historialTicketAux = (HistorialTicket) _resultObject[0];
                Usuario _usuarioAux = (Usuario) _resultObject[1];
                Accion _accionAux = (Accion) _resultObject[2];
                Inhibidor _inhibidorAux = (Inhibidor) _resultObject[3];
                _historialTicketAux.setUsuariodata(_usuarioAux);
                _historialTicketAux.setAcciondata(_accionAux);
                _historialTicketAux.setIdinhibidordata(_inhibidorAux);
                _listHistorialTicket.add(_historialTicketAux);
            }

        }

        return  _listHistorialTicket;
    }

    //getAllHistorialTicket

    @Override
    public List<HistorialTicket> getAllHistorialTicket() {

        List<HistorialTicket> _listHistorialTicket = new ArrayList<>();

        String _sqlString = ConsultaSQL._LISTAR_HISTORIAL_TICKETS;

        Query q = _entityManager.createNativeQuery(_sqlString, "HistorialTicketHLPMapping");
        List<Object[]> _listResultQuery = q.getResultList();

        if (!_listResultQuery.isEmpty()) {

            for (Object[] _resultObject : _listResultQuery) {
                HistorialTicket _historialTicketAux = (HistorialTicket) _resultObject[0];
                Usuario _usuarioAux = (Usuario) _resultObject[1];
                Accion _accionAux = (Accion) _resultObject[2];
                Inhibidor _inhibidorAux = (Inhibidor) _resultObject[3];
                _historialTicketAux.setUsuariodata(_usuarioAux);
                _historialTicketAux.setAcciondata(_accionAux);
                _historialTicketAux.setIdinhibidordata(_inhibidorAux);
                _listHistorialTicket.add(_historialTicketAux);
            }

        }

        return  _listHistorialTicket;
    }

}
