package Pojos;

import java.sql.Date;

/**
 *
 * @author Fernando
 */
public class Disco {
    
    private final int id;
    private final String nombre;
    private final Date fecha;

    public Disco(int id, String nombre, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }
    
}
