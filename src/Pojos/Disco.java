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
    private final String url_img;
    
    public Disco(int id, String nombre, Date fecha, String url_img) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.url_img = url_img;
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

    public String getUrl_img() {
        return url_img;
    }
}
