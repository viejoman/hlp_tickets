package corp.galvan.hlp.ticket.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@SqlResultSetMappings( {

        @SqlResultSetMapping(
                name = "UsuarioHLPMapping",
                entities = {
                        @EntityResult(
                                entityClass = Usuario.class,
                                fields = {
                                        @FieldResult(name = "idusuario", column = "idusuario"),
                                        @FieldResult(name = "usuario", column = "usuario"),
                                        @FieldResult(name = "nombre", column = "nombre"),
                                        @FieldResult(name = "apaterno", column = "apaterno"),
                                        @FieldResult(name = "amaterno", column = "amaterno"),
                                        @FieldResult(name = "idgrupo", column = "idgrupo"),
                                        @FieldResult(name = "idsucursal", column = "idoficina"),
                                        @FieldResult(name = "email", column = "email")
                                }
                        )

                }
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "funcGetUsuarioById",
                query = "select * from desarrollo.getUsuarioById(:p_idusuario)",
                resultSetMapping = "UsuarioHLPMapping"
        )
})
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
