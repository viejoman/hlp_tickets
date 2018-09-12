package corp.galvan.hlp.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity(name = "Oficina")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Oficina implements Serializable {

    @Id
    private Long idoficina;

    private String clave;

    private String nombre;

}