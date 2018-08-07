package corp.galvan.hlp.ticket.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    private Long idusuario;
    private String usuario;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String email;
    private Long idsucursal;
    private Long idgrupo;

}
