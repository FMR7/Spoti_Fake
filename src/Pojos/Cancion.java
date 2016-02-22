package Pojos;

/**
 *
 * @author Fernando
 */
public class Cancion {
    private final int id;
    private final String nombre;
    private final int id_disco;
    private final String url;
    private final int rating;
    private final String genero;

    public Cancion(int id, String nombre, int id_disco, String url, int rating, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.id_disco = id_disco;
        this.url = url;
        this.rating = rating;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId_disco() {
        return id_disco;
    }

    public String getUrl() {
        return url;
    }

    public int getRating() {
        return rating;
    }

    public String getGenero() {
        return genero;
    }
}
