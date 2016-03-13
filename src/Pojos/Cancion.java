package Pojos;

/**
 *
 * @author Fernando
 * @since V 0.1
 */
public class Cancion {
    private final int id;
    private final String nombre;
    private final int id_disco;
    private final String url;
    private final int rating;
    private final String genero;

    /**
     * 
     * @param id
     * @param nombre
     * @param id_disco
     * @param url
     * @param rating
     * @param genero 
     */
    public Cancion(int id, String nombre, int id_disco, String url, int rating, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.id_disco = id_disco;
        this.url = url;
        this.rating = rating;
        this.genero = genero;
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
     * @return id_disco
     */
    public int getId_disco() {
        return id_disco;
    }

    /**
     * 
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @return rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * 
     * @return genero
     */
    public String getGenero() {
        return genero;
    }
}
