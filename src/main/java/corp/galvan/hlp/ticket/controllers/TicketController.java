package corp.galvan.hlp.ticket.controllers;

import corp.galvan.hlp.ticket.domain.HistorialTicket;
import corp.galvan.hlp.ticket.domain.Ticket;
import corp.galvan.hlp.ticket.enums.Acciones;
import corp.galvan.hlp.ticket.enums.Estados;
import corp.galvan.hlp.ticket.exception.ResourceNotFoundException;
import corp.galvan.hlp.ticket.model.TicketModel;
import corp.galvan.hlp.ticket.service.AdjuntoDoctoTicketService;
import corp.galvan.hlp.ticket.service.HistorialTicketService;
import corp.galvan.hlp.ticket.service.TicketService;
import corp.galvan.hlp.ticket.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService _ticketService;

    @Autowired
    private HistorialTicketService _historialTicketService;

    @Autowired
    private AdjuntoDoctoTicketService _adjuntoDoctoTicketService;

    @Autowired
    private UsuarioService _usuarioService;

    Logger _log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public void setTicketService(TicketService p__ticketService) {
        this._ticketService = p__ticketService;
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public TicketModel addTicket(@RequestBody Ticket p__ticket)
    {
        TicketModel _TicketModel = new TicketModel();

        Boolean _isNew = (p__ticket.getIdticket() > 0L) ? true : false;

        List<Ticket> _listTicket = new ArrayList<Ticket>();
        if (validarTicket(p__ticket)) {

            _TicketModel.setSuccess(true);
            p__ticket = _ticketService.saveOrUpdate(p__ticket);
            _log.debug("Added:: " + p__ticket);
            _TicketModel.setMessage("Ticket Added");
            _listTicket.add(p__ticket);

        } else {
            _TicketModel.setSuccess(false);
            _TicketModel.setMessage("Objeto Ticket incompleto");
        }
        _TicketModel.setCode("200");
        _TicketModel.setData(_listTicket);
        return _TicketModel;
    }

    @RequestMapping(value = "/newList",method = RequestMethod.POST)
    public TicketModel addListTicket(@RequestBody List<Ticket> p__listTicket)
    {
        TicketModel _TicketModel = new TicketModel();

        List<Ticket> _listTicket = new ArrayList<Ticket>();

        for (Ticket p__ticket : p__listTicket) {

            Boolean _isNew = (p__ticket.getIdticket() > 0L) ? true : false;

            if (validarTicket(p__ticket)) {
                p__ticket = _ticketService.saveOrUpdate(p__ticket);
                _log.debug("Added:: " + p__ticket);
                _listTicket.add(p__ticket);
            }

        }

        _TicketModel.setSuccess(true);
        _TicketModel.setMessage("Ticket Added");
        _TicketModel.setCode("200");
        _TicketModel.setData(_listTicket);
        return _TicketModel;
    }

    private Boolean validarTicket(Ticket p__ticket)
    {
        Boolean _valido = true;

        if ((p__ticket.getIdticket() == null) ||
            (p__ticket.getReferencia() == null) ||
            (p__ticket.getTitulo() == null) ||
            (p__ticket.getDescripcion() == null) || (p__ticket.getIdtiposervicio() == null) ||
            (p__ticket.getIdusuario() == null) || (p__ticket.getFecharegistro() == null)) {
            _valido = false;
        }

        return  _valido;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public TicketModel updateTicket(@RequestBody Ticket p__ticket)
    {
        TicketModel _TicketModel = new TicketModel();
        List<Ticket> _listTicket = new ArrayList<Ticket>();
        Ticket existTicket = _ticketService.getById(p__ticket.getIdticket());
        if (existTicket == null) {
            _TicketModel.setSuccess(false);
            _log.debug("Ticket with id " + p__ticket.getIdticket() + " does not exists");
            _TicketModel.setMessage("Ticket with id " + p__ticket.getIdticket() + " does not exists");
            _listTicket.add(p__ticket);
        } else {
            _TicketModel.setSuccess(true);
            _ticketService.saveOrUpdate(p__ticket);
            _TicketModel.setMessage("Ticket Edited");
            _listTicket.add(p__ticket);
        }
        _TicketModel.setCode("200");
        _TicketModel.setData(_listTicket);
        return _TicketModel;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public Long deleteTicket(@RequestBody Ticket p__ticket)
    {
        Ticket existTicket = _ticketService.getById(p__ticket.getIdticket());
        if (existTicket == null) {
            _log.debug("Ticket with id " + p__ticket.getIdticket() + " does not exists");
            return 0L;
        } else {
            _ticketService.delete(p__ticket.getIdticket());
            return 1L;
        }
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public Ticket getTicketById(@PathVariable("id") Long p__id)
    {
        Ticket _ticket = _ticketService.getById(p__id);
        if (_ticket == null) {
            _log.debug("Ticket with id " + p__id + " does not exists");
            //return new Ticket();
            throw new ResourceNotFoundException(p__id, "Ticket not found");

        }
        _log.debug("Found Ticket:: " + _ticket);
        return _ticket;
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public List<Ticket> getAllTickets()
    {
        List<Ticket> _listTickets = _ticketService.listAll();
        if (_listTickets.isEmpty()) {
            _log.debug("Ticket does not exists");

        }
        _log.debug("Se encontraron " + _listTickets.size() + " Ticket(s)");
        _log.debug(Arrays.toString(_listTickets.toArray()));
        return _listTickets;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Long deleteTicketById(@PathVariable("id") Long p__id)
    {
        Ticket existTicket = _ticketService.getById(p__id);
        if (existTicket == null) {
            _log.debug("Ticket with id " + p__id + " does not exists");
            return 0L;
        } else {
            _ticketService.delete(p__id);
            return 1L;
        }
    }

    @RequestMapping(value = "/hlp/show", method = RequestMethod.GET)
    public TicketModel getAllTicketsHLP()
    {
        TicketModel _TicketModel = new TicketModel();

        List<Ticket> _listTicket = _ticketService.listAll();
        _TicketModel.setSuccess(true);
        if (_listTicket.isEmpty()) {
            _TicketModel.setMessage("No hay registros de tickets");
        } else {
            _TicketModel.setMessage("Se encontraron " + _listTicket.size() + " Ticket(s)");
        }
        _TicketModel.setCode("200");
        _TicketModel.setData(_listTicket);

        return _TicketModel;
    }


    @RequestMapping(value = "/hlp/{idgrupo}/shownew/{idusuario}", method = RequestMethod.GET)
    public TicketModel getAllTicketsHLPByUsuario(@PathVariable long idgrupo, @PathVariable long idusuario, @RequestParam("page") long page, @RequestParam("start") long start, @RequestParam("limit") long limit)
    {
        return getAllTicketUsuarioByEstatus(idgrupo, idusuario, Estados._NUEVO, page, start, limit);
    }

    @RequestMapping(value = "/hlp/{idgrupo}/showprocessed/{idusuario}", method = RequestMethod.GET)
    public TicketModel getAllTicketsProcessedHLPByUsuario(@PathVariable long idgrupo, @PathVariable long idusuario, @RequestParam("page") long page, @RequestParam("start") long start, @RequestParam("limit") long limit)
    {
        return getAllTicketUsuarioByEstatus(idgrupo, idusuario, Estados._EN_PROCESO, page, start, limit);
    }

    @RequestMapping(value = "/hlp/{idgrupo}/showclosed/{idusuario}", method = RequestMethod.GET)
    public TicketModel getAllTicketsCanceledHLPByUsuario(@PathVariable long idgrupo, @PathVariable long idusuario, @RequestParam("page") long page, @RequestParam("start") long start, @RequestParam("limit") long limit)
    {
        return getAllTicketUsuarioByEstatus(idgrupo, idusuario, Estados._CERRADO, page, start, limit);
    }

    private TicketModel getAllTicketUsuarioByEstatus(Long p__idgrupo, Long p__idusuario, Long p__idestatus, Long page, Long start, Long limit)
    {

        TicketModel _TicketModel = new TicketModel();
        List<Ticket> _listTicket = new ArrayList<Ticket>();

        if (p__idestatus == Estados._CERRADO) {
            _listTicket = _ticketService.getListTicketCanceladosCerradosByIdUsuario(p__idgrupo, p__idusuario);
        } else {
            _listTicket = _ticketService.getListTicketUsuarioByIdEstado(p__idgrupo, p__idusuario, p__idestatus);
        }

        _TicketModel.setTotal(_listTicket.size());

        _listTicket = _listTicket.stream().skip((page - 1) * limit).limit(limit).collect(Collectors.toList());

        for (Ticket _ticketAux : _listTicket) {
            //_ticketAux.setHistorialtickets(_historialTicketService.findByIdticket(_ticketAux.getIdticket()));
            //getHistorialTicketByIdticket
            _ticketAux.setHistorialtickets(_historialTicketService.getHistorialTicketByIdticket(_ticketAux.getIdticket()));
            _ticketAux.setAdjuntodoctotickets(_adjuntoDoctoTicketService.findByIdticket(_ticketAux.getIdticket()));
            _ticketAux.setUsuariosisdata(_usuarioService.getById(_ticketAux.getIdusuariosis()));
        }

        _TicketModel.setSuccess(true);

        if (_listTicket.isEmpty()) {
            _TicketModel.setMessage("No hay registros de tickets");
        } else {
            _TicketModel.setMessage("Se encontraron " + _listTicket.size() + " Ticket(s)");
        }
        _TicketModel.setCode("200");
        _TicketModel.setData(_listTicket);

        return _TicketModel;

    }

}
