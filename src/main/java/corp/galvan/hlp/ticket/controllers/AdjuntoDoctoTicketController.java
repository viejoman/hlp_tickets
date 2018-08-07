package corp.galvan.hlp.ticket.controllers;


import corp.galvan.hlp.ticket.domain.AdjuntoDoctoTicket;
import corp.galvan.hlp.ticket.model.AdjuntoDoctoTicketModel;
import corp.galvan.hlp.ticket.service.AdjuntoDoctoTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping("/attachment")
public class AdjuntoDoctoTicketController {

    @Autowired
    private AdjuntoDoctoTicketService _service;

    @RequestMapping(value = "/docto/new",method = RequestMethod.POST)
    public AdjuntoDoctoTicketModel addAdjuntoDoctoTicket(@RequestBody AdjuntoDoctoTicket p__adjuntoDoctoTicket)
    {

        AdjuntoDoctoTicketModel _model = new AdjuntoDoctoTicketModel();

        p__adjuntoDoctoTicket = _service.saveOrUpdate(p__adjuntoDoctoTicket);

        if (p__adjuntoDoctoTicket.getIdadjuntodoctoticket().equals(0)) {
            _model.setSuccess(false);
            _model.setCode("500");
            _model.setMessage("No se pudo registrar el documento, revise situacion");
        } else {
            _model.setSuccess(true);
            _model.setCode("200");
            _model.setMessage("Se registro documento OKAY!");
        }

        return _model;
    }

    @RequestMapping(value = "/docto/{idadjuntoticket}",method = RequestMethod.GET)
    public AdjuntoDoctoTicketModel getAdjuntoDoctoByIdAdjuntoDoctoTicket(@PathVariable("idadjuntoticket") Long p__idadjuntodoctoticket)
    {
        List<AdjuntoDoctoTicket> _listAdjuntoTicket = new ArrayList<>();

        AdjuntoDoctoTicketModel _model = new AdjuntoDoctoTicketModel();

        AdjuntoDoctoTicket _adjuntoTicket = _service.getById(p__idadjuntodoctoticket);

        if (_adjuntoTicket == null) {
            _model.setMessage("No hay registros para el Documento Adjunto con Id # " + p__idadjuntodoctoticket);
        } else {
            _model.setMessage("Documento encontrado OKAY!");
            _listAdjuntoTicket.add(_adjuntoTicket);
        }

        _model.setSuccess(true);
        _model.setCode("200");
        _model.setData(_listAdjuntoTicket);

        return _model;
    }

    @RequestMapping(value = "/docto/show/{idticket}",method = RequestMethod.GET)
    public AdjuntoDoctoTicketModel getAdjuntoDoctoByIdticket(@PathVariable("idticket") Long p__idticket)
    {

        AdjuntoDoctoTicketModel _model = new AdjuntoDoctoTicketModel();

        List<AdjuntoDoctoTicket> _listAdjuntoTicket = _service.findByIdticket(p__idticket);

        if (_listAdjuntoTicket.isEmpty()) {
            _model.setMessage("No hay registros de adjuntos para el Ticket #" + p__idticket);
        } else {
            _model.setMessage("Se encontraron " + _listAdjuntoTicket.size() + " adjunto(s) para Ticket #" + p__idticket);
        }

        _model.setSuccess(true);
        _model.setCode("200");
        _model.setData(_listAdjuntoTicket);

        return _model;
    }

    @RequestMapping(value = "/docto/delete",method = RequestMethod.POST)
    public AdjuntoDoctoTicketModel deleteAdjuntoDoctoTicket(@RequestBody List<AdjuntoDoctoTicket> p__listAdjuntoDoctoTicket)
    {

        AdjuntoDoctoTicketModel _model = new AdjuntoDoctoTicketModel();

        for (AdjuntoDoctoTicket _adjuntoDoctoAux : p__listAdjuntoDoctoTicket) {
            _service.delete(_adjuntoDoctoAux.getIdadjuntodoctoticket());
        }

        _model.setSuccess(true);
        _model.setCode("200");
        _model.setMessage("Se eliminaron documentos OKAY!");

        return _model;
    }

}
