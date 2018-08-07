package corp.galvan.hlp.ticket.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "hlp_adjuntodocto_tickets", schema = "desarrollo")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AdjuntoDoctoTicket  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "idadjuntodoctoticket", unique = true, nullable = false)
    private Long idadjuntodoctoticket;

    @Column(name = "idticket")
    private Long idticket;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "idtipodocto")
    private Long idtipodocto;

    @Column(name = "tipocontenido")
    private String tipocontenido;

    @Column(name = "contenido", length=10485760)
    private String contenido;

    @Column(name = "idusuario")
    private Long idusuario;

}
