package corp.galvan.hlp.ticket.service;

import corp.galvan.hlp.ticket.domain.AdjuntoDoctoTicket;
import corp.galvan.hlp.ticket.repositories.AdjuntoDoctoTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdjuntoDoctoTicketServiceImpl implements AdjuntoDoctoTicketService {

    @PersistenceContext
    private EntityManager _entityManager;

    private AdjuntoDoctoTicketRepository _Repository;

    @Autowired
    public AdjuntoDoctoTicketServiceImpl(AdjuntoDoctoTicketRepository p__Repository) {
        this._Repository = p__Repository;
    }

    @Override
    public List<AdjuntoDoctoTicket> listAll() {
        List<AdjuntoDoctoTicket> _adjuntoDoctoTicket = new ArrayList<>();
        _Repository.findAll().forEach(_adjuntoDoctoTicket::add);
        return _adjuntoDoctoTicket;
    }

    @Override
    public AdjuntoDoctoTicket getById(Long id) {
        return _Repository.findById(id).orElse(null);
    }

    @Override
    public AdjuntoDoctoTicket saveOrUpdate(AdjuntoDoctoTicket model) {
        model = _Repository.save(model);
        return model;
    }

    @Override
    public void delete(Long id) {
        _Repository.deleteById(id);
    }

    @Override
    public List<AdjuntoDoctoTicket> findByIdticket(Long idticket) {
        return _Repository.findByIdticket(idticket);
    }

}
