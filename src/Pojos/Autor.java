package Pojos;

/**
 *
 * @author Fernando
 * @since V 0.1
 */
public class Autor {
    private final int id;
    private final String nombre;

    /**
     * 
     * @param id
     * @param nombre 
     */
    public Autor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
    
    
}
