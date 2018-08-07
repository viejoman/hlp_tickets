package corp.galvan.hlp.ticket.domain;

import corp.galvan.hlp.ticket.controllers.HistorialTicketController;
import corp.galvan.hlp.ticket.converters.LocalDateTimeConverter;
import corp.galvan.hlp.ticket.model.Accion;
import corp.galvan.hlp.ticket.model.Inhibidor;
import corp.galvan.hlp.ticket.model.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "hlp_historialtickets", schema = "desarrollo")
@SqlResultSetMappings( {
        @SqlResultSetMapping(
                name = "HistorialTicketHLPMapping",
                entities = {
                        @EntityResult(
                                entityClass = HistorialTicket.class,
                                fields = {
                                        @FieldResult(name = "idhistorialticket", column = "idhistorialticket"),
                                        @FieldResult(name = "idticket", column = "idticket"),
                                        @FieldResult(name = "idaccion", column = "idaccion"),
                                        @FieldResult(name = "fecharegistro", column = "fecharegistro"),
                                        @FieldResult(name = "idinhibidor", column = "idinhibidor"),
                                        @FieldResult(name = "observaciones", column = "observaciones"),
                                        @FieldResult(name = "idusuario", column = "idusuario")
                                }
                        ),
                        @EntityResult(
                                entityClass = Usuario.class,
                                fields = {
                                        @FieldResult(name = "idusuario", column = "id_usrtk"),
                                        @FieldResult(name = "usuario", column = "usuario_usrtk"),
                                        @FieldResult(name = "nombre", column = "nombre_usrtk"),
                                        @FieldResult(name = "apaterno", column = "apaterno_usrtk"),
                                        @FieldResult(name = "amaterno", column = "amaterno_usrtk"),
                                        @FieldResult(name = "email", column = "email_usrtk"),
                                        @FieldResult(name = "idsucursal", column = "idsucursal_usrtk"),
                                        @FieldResult(name = "idgrupo", column = "idgrupo_usrtk")
                                }
                        ),
                        @EntityResult(
                                entityClass = Accion.class,
                                fields = {
                                        @FieldResult(name = "idaccion", column = "id_ac"),
                                        @FieldResult(name = "nombre", column = "nombre_ac")
                                }
                        ),
                        @EntityResult(
                                entityClass = Inhibidor.class,
                                fields = {
                                        @FieldResult(name = "idinhibidor", column = "id_inhibidor"),
                                        @FieldResult(name = "nombre", column = "nombre_inh"),
                                        @FieldResult(name = "codigo", column = "codigo_inh"),
                                        @FieldResult(name = "idtipoinhibidor", column = "idtipoinhibidor_inh")
                                }
                        )
                }
        )
})
public class HistorialTicket implements Serializable {

    public Long getIdhistorialticket() {
        return idhistorialticket;
    }

    public void setIdhistorialticket(Long idhistorialticket) {
        this.idhistorialticket = idhistorialticket;
    }

    public Long getIdticket() {
        return idticket;
    }

    public void setIdticket(Long idticket) {
        this.idticket = idticket;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(LocalDateTime fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Long getIdaccion() {
        return idaccion;
    }

    public void setIdaccion(Long idaccion) {
        this.idaccion = idaccion;
    }

    public Long getIdinhibidor() {
        return idinhibidor;
    }

    public void setIdinhibidor(Long idinhibidor) {
        this.idinhibidor = idinhibidor;
    }

    public Usuario getUsuariodata() {
        return usuariodata;
    }

    public void setUsuariodata(Usuario usuariodata) {
        this.usuariodata = usuariodata;
    }

    public Accion getAcciondata() {
        return acciondata;
    }

    public void setAcciondata(Accion acciondata) {
        this.acciondata = acciondata;
    }

    public Inhibidor getIdinhibidordata() {
        return idinhibidordata;
    }

    public void setIdinhibidordata(Inhibidor idinhibidordata) {
        this.idinhibidordata = idinhibidordata;
    }

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "IDHISTORIAL_TICKET_SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "idhistorialticket", unique = true, nullable = false)
    //@SequenceGenerator(sequenceName = "idhistorial_ticket_seq", allocationSize = 1, name = "IDHISTORIAL_TICKET_SEQ")
    private Long idhistorialticket;

    @NotNull
    @Column(name = "idticket")
    private Long idticket;

    @Column(name = "idusuario")
    private Long idusuario;

    @Transient
    private Usuario usuariodata;

    @Column(name = "observaciones", length=10485760)
    private String observaciones;

    @NotNull
    @Column(name="fecharegistro")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime fecharegistro;

    @Column(name = "idaccion")
    private Long idaccion;

    @Transient
    private Accion acciondata;

    @Column(name = "idinhibidor")
    private Long idinhibidor;

    @Transient
    private Inhibidor idinhibidordata;

    public HistorialTicket(@NotNull Long idhistorialticket, @NotNull Long idticket, Long idusuario, Usuario usuariodata, String observaciones, @NotNull LocalDateTime fecharegistro, Long idaccion, Accion acciondata, Long idinhibidor, Inhibidor idinhibidordata) {
        this.idhistorialticket = idhistorialticket;
        this.idticket = idticket;
        this.idusuario = idusuario;
        this.usuariodata = usuariodata;
        this.observaciones = observaciones;
        this.fecharegistro = fecharegistro;
        this.idaccion = idaccion;
        this.acciondata = acciondata;
        this.idinhibidor = idinhibidor;
        this.idinhibidordata = idinhibidordata;
    }

    public HistorialTicket() {
    }
}
