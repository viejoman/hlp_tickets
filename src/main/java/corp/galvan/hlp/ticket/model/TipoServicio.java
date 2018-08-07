package corp.galvan.hlp.ticket.model;

import javax.persistence.*;

@Entity(name = "TipoServicio")
public class TipoServicio {

    @Id
    private Long idtiposervicio;

    private String nombre;

    public Long getIdtiposervicio() {
        return idtiposervicio;
    }

    public void setIdtiposervicio(Long idtiposervicio) {
        this.idtiposervicio = idtiposervicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoServicio(Long idtiposervicio, String nombre) {
        this.idtiposervicio = idtiposervicio;
        this.nombre = nombre;
    }

    public TipoServicio() {
    }
}
