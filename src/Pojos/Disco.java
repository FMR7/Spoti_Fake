package Pojos;

import java.sql.Date;

/**
 *
 * @author Fernando
 * @since V 0.1
 */
public class Disco {
    
    private final int id;
    private final String nombre;
    private final Date fecha;
    private final String url_img;
    
    /**
     * 
     * @param id
     * @param nombre
     * @param fecha
     * @param url_img 
     */
    public Disco(int id, String nombre, Date fecha, String url_img) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.url_img = url_img;
    }

    /**
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @return fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * 
     * @return image url
     */
    public String getUrl_img() {
        return url_img;
    }
}
