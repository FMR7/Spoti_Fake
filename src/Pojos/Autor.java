package Pojos;

/**
 *
 * @author Fernando
 */
public class Autor {
    private final int id;
    private final String nombre;

    public Autor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
