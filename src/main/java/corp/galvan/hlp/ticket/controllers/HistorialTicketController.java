package corp.galvan.hlp.ticket.controllers;

import corp.galvan.hlp.ticket.domain.HistorialTicket;
import corp.galvan.hlp.ticket.model.HistorialTicketModel;
import corp.galvan.hlp.ticket.service.HistorialTicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class HistorialTicketController {

    @Autowired
    private HistorialTicketService _historialTicketService;

    Logger _log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public void setTicketService(HistorialTicketService p__historialTicketService) {
        this._historialTicketService = p__historialTicketService;
    }

    @RequestMapping(value = "/historial/new",method = RequestMethod.POST)
    public HistorialTicket addHistorialTicket(@RequestBody HistorialTicket p__historialTicket) {
        p__historialTicket = _historialTicketService.saveOrUpdate(p__historialTicket);
        _log.debug("Added:: " + p__historialTicket);
        return p__historialTicket;
    }

    @RequestMapping(value = "/historial/edit",method = RequestMethod.PUT)
    public Long updateHistorialTicket(@RequestBody HistorialTicket p__hitorialTicket) {
        HistorialTicket existHitorialTicket = _historialTicketService.getById(p__hitorialTicket.getIdhistorialticket());
        if (existHitorialTicket == null) {
            _log.debug("HistorialTicket with id " + p__hitorialTicket.getIdhistorialticket() + " does not exists");
            return 0L;
        } else {
            _historialTicketService.saveOrUpdate(p__hitorialTicket);
            return p__hitorialTicket.getIdhistorialticket();
        }
    }

    @RequestMapping(value = "/historial/delete",method = RequestMethod.DELETE)
    public Long deleteTicket(@RequestBody HistorialTicket p__historialTicket) {
        HistorialTicket existHitorialTicket = _historialTicketService.getById(p__historialTicket.getIdhistorialticket());
        if (existHitorialTicket == null) {
            _log.debug("HistorialTicket with id " + p__historialTicket.getIdhistorialticket() + " does not exists");
            return 0L;
        } else {
            _historialTicketService.delete(p__historialTicket.getIdhistorialticket());
            return 1L;
        }
    }

    @RequestMapping(value = "/historial/show/{id}", method = RequestMethod.GET)
    public HistorialTicket getHitorialTicketById(@PathVariable("id") Long p__id) {
        HistorialTicket _historialTicket = _historialTicketService.getById(p__id);
        if (_historialTicket == null) {
            _log.debug("HistorialTicket with id " + p__id + " does not exists");
            return new HistorialTicket();
        }
        _log.debug("Found HistorialTicket:: " + _historialTicket);
        return _historialTicket;
    }

    @RequestMapping(value = "/historial/delete/{id}",method = RequestMethod.DELETE)
    public Long deleteHistorialTicketById(@PathVariable("id") Long p__id) {
        HistorialTicket existTicket = _historialTicketService.getById(p__id);
        if (existTicket == null) {
            _log.debug("HistorialTicket with id " + p__id + " does not exists");
            return 0L;
        } else {
            _historialTicketService.delete(p__id);
            return 1L;
        }
    }

    @RequestMapping(value = "/historial/hlp/show", method = RequestMethod.GET)
    public HistorialTicketModel getAllHistorialTicketsHLP()
    {
        HistorialTicketModel _historialTicketModel = new HistorialTicketModel();

        List<HistorialTicket> _listHistorialTicket = _historialTicketService.getAllHistorialTicket();
        _historialTicketModel.setSuccess(true);
        if (_listHistorialTicket.isEmpty()) {
            _historialTicketModel.setMessage("No hay registros de historial tickets");
        } else {
            _historialTicketModel.setMessage("Se encontraron " + _listHistorialTicket.size() + " Ticket(s) en el Historial");
        }
        _historialTicketModel.setCode("200");
        _historialTicketModel.setData(_listHistorialTicket);

        return _historialTicketModel;
    }

    @RequestMapping(value = "/historial/showticket/{id}",method = RequestMethod.GET)
    public HistorialTicketModel getHistorialTicketByIdTicket(@PathVariable("id") Long p__id) {
        //return _historialTicketService.findByIdticket(p__id);
        //return _historialTicketService.getHistorialTicketByIdticket(p__id);
        HistorialTicketModel _historialTicketModel = new HistorialTicketModel();

        List<HistorialTicket> _listHistorialTicket = _historialTicketService.getHistorialTicketByIdticket(p__id);
        _historialTicketModel.setSuccess(true);
        if (_listHistorialTicket.isEmpty()) {
            _historialTicketModel.setMessage("No hay registros de historial tickets");
        } else {
            _historialTicketModel.setMessage("Se encontraron " + _listHistorialTicket.size() + " Ticket(s) en el Historial");
        }
        _historialTicketModel.setCode("200");
        _historialTicketModel.setData(_listHistorialTicket);

        return _historialTicketModel;
    }

}
