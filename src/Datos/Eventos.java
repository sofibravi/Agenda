
package Datos;

/**
 *
 * @author Sofia
 */
public class Eventos {
    private int id;
    private String evento;
    private String fecha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Eventos() {
    }

    public Eventos(String evento, String fecha) {
        this.evento = evento;
        this.fecha = fecha;
    }
    
    
}
