package Pojos;

/**
 *
 * @author Fernando
 */
public class Grupo {
    private int id;
    private String nombre;

    public Grupo(int id, String nombre) {
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
