package corp.galvan.hlp.ticket.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Accion")
public class Accion
{
    @Id
    private Long idaccion;
    private String nombre;

    public Long getIdaccion() {
        return idaccion;
    }

    public void setIdaccion(Long idaccion) {
        this.idaccion = idaccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Accion(Long idaccion, String nombre) {
        this.idaccion = idaccion;
        this.nombre = nombre;
    }

    public Accion() {
    }
}
