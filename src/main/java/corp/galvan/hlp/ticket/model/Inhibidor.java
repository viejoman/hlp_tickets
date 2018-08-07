package corp.galvan.hlp.ticket.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Inhibidor")
public class Inhibidor {

    @Id
    private Long idinhibidor;

    private String codigo;

    private String nombre;

    private Integer idtipoinhibidor;


    public Long getIdinhibidor() {
        return idinhibidor;
    }

    public void setIdinhibidor(Long idinhibidor) {
        this.idinhibidor = idinhibidor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdtipoinhibidor() {
        return idtipoinhibidor;
    }

    public void setIdtipoinhibidor(Integer idtipoinhibidor) {
        this.idtipoinhibidor = idtipoinhibidor;
    }

    public Inhibidor(Long idinhibidor, String codigo, String nombre, Integer idtipoinhibidor) {
        this.idinhibidor = idinhibidor;
        this.codigo = codigo;
        this.nombre = nombre;
        this.idtipoinhibidor = idtipoinhibidor;
    }

    public Inhibidor() {
    }
}
