package Pojos;

/**
 * 
 * @author Fernando
 * @since V 0.4
 */
public class Grupo {
    private int id;
    private String nombre;
    
    /**
     * 
     * @param id
     * @param nombre 
     */
    public Grupo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * 
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @return String nombre
     */
    public String getNombre() {
        return nombre;
    }
}
