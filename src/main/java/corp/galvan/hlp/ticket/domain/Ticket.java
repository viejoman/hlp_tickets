package corp.galvan.hlp.ticket.domain;

import corp.galvan.hlp.ticket.converters.LocalDateTimeConverter;
import corp.galvan.hlp.ticket.model.Oficina;
import corp.galvan.hlp.ticket.model.TipoServicio;
import corp.galvan.hlp.ticket.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "hlp_tickets", schema = "desarrollo")
@NamedStoredProcedureQuery(
        name = "obtenerTicketByIdUsuario",
        procedureName = "desarrollo.getTicketByIdUsuario",
        resultClasses = { Ticket.class },
        parameters = {
                @StoredProcedureParameter(name="idgrupo", mode = ParameterMode.IN, type = Long.class),
                @StoredProcedureParameter(name="idusuario", mode = ParameterMode.IN, type = Long.class)
        }
)
@SqlResultSetMappings( {
        @SqlResultSetMapping(
                name = "TicketHLPMapping",
                entities = {
                        @EntityResult(
                                entityClass = Ticket.class,
                                fields = {
                                        @FieldResult(name = "idticket", column = "idticket"),
                                        @FieldResult(name = "descripcion", column = "descripcion"),
                                        @FieldResult(name = "fechaapertura", column = "fechaapertura"),
                                        @FieldResult(name = "fechaasignado", column = "fechaasignado"),
                                        @FieldResult(name = "fechacierre", column = "fechacierre"),
                                        @FieldResult(name = "fechaevaluacion", column = "fechaevaluacion"),
                                        @FieldResult(name = "fecharegistro", column = "fecharegistro"),
                                        @FieldResult(name = "idcategoriaserv", column = "idcategoriaserv"),
                                        @FieldResult(name = "idestado", column = "idestado"),
                                        @FieldResult(name = "idprioridad", column = "idprioridad"),
                                        @FieldResult(name = "idsubcategoriaserv", column = "idsubcategoriaserv"),
                                        @FieldResult(name = "idsucursal", column = "idsucursal"),
                                        @FieldResult(name = "idtiposervicio", column = "id_tiposervicioticket"),
                                        @FieldResult(name = "idusuario", column = "idusuario"),
                                        @FieldResult(name = "idusuariosis", column = "idusuariosis"),
                                        @FieldResult(name = "indicevaloracion", column = "indicevaloracion"),
                                        @FieldResult(name = "referencia", column = "referencia"),
                                        @FieldResult(name = "fechaatencion", column = "fechaatencion"),
                                        @FieldResult(name = "titulo", column = "titulo")
                                }
                        ),
                        @EntityResult(
                                entityClass = TipoServicio.class,
                                fields = {
                                        @FieldResult(name = "idtiposervicio", column = "id_tiposervicio"),
                                        @FieldResult(name = "nombre", column = "nombre_tiposervicio")
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
                                entityClass = Oficina.class,
                                fields = {
                                        @FieldResult(name = "idoficina", column = "id_oficina"),
                                        @FieldResult(name = "clave", column = "clave_oficina"),
                                        @FieldResult(name = "nombre", column = "nombre_oficina")
                                }
                        )
                }
        )
})
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Ticket implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "IDTICKET_SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "idticket", unique = true, nullable = false)
    //@SequenceGenerator(sequenceName = "idticket_seq", allocationSize = 1, name = "IDTICKET_SEQ")
    private Long idticket;

    @NotNull
    @Column(name = "referencia", length = 60)
    private String referencia;

    @NotNull
    @Column(name = "titulo", length = 255)
    private String titulo;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "idprioridad")
    private Long idprioridad;

    @NotNull
    @Column(name="idtiposervicio")
    private Long idtiposervicio;

    @Transient
    private TipoServicio tiposerviciodata;

    @Column(name="idcategoriaserv")
    private Long idcategoriaserv;

    @Column(name="idsubcategoriaserv")
    private Long idsubcategoriaserv;

    @Column(name="idestado")
    private Long idestado;

    @NotNull
    @Column(name="idusuario")
    private Long idusuario;

    @Transient
    private Usuario usuariodata;

    @Column(name="idusuariosis")
    private Long idusuariosis;

    @Transient
    private Usuario usuariosisdata;

    @NotNull
    @Column(name="fecharegistro")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime fecharegistro;

    @Column(name="fechaasignado")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime fechaasignado;

    @Column(name="fechaapertura")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime fechaapertura;

    @Transient
    private Boolean bTieneFechaApertura;

    @Column(name="fechacierre")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime fechacierre;

    @Column(name="indicevaloracion")
    private Integer indicevaloracion;

    @Column(name="fechaevaluacion")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime fechaevaluacion;

    @Column(name="idsucursal")
    private Long idsucursal;

    @Transient
    private Oficina sucursaldata;

    @Column(name="fechaatencion")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime fechaatencion;

    @Transient
    private List<HistorialTicket> historialtickets;

    @Transient
    private List<AdjuntoDoctoTicket> adjuntodoctotickets;

}
