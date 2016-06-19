package Dao;

import Pojos.Cancion;
import fmr.persistence.ConfigFiles;
import java.util.List;
import java.util.Properties;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import spotifake.db;
import spotifake.gui;
import static spotifake.gui.jLabel_album_img;

/**
 *
 * @author Fernando
 * @since V 0.2
 */
public class Dao_canciones {
    private DefaultMutableTreeNode raiz;
    private DefaultTreeModel modelo;
    private db DB;
    
    /**
     * 
     * Default constructor.
     */
    public Dao_canciones() {
        this.raiz = new DefaultMutableTreeNode("\\");
        this.DB = new db();
    }
    
    /**
     * 
     * Customize the root node of the jTree.
     * @param name Nombre de la cancián o del disco
     * @param n 1 = canción, 2 = disco
     */
    public Dao_canciones(String name, int n) {
        ConfigFiles cf = new ConfigFiles();
        Properties loadFile = cf.loadFile("conf\\" + "LANG", true);
        String lang = loadFile.getProperty("lang");
        switch (n){
            case 1:
                if("ES".equals(lang)){
                    this.raiz = new DefaultMutableTreeNode("Canciones de " + name);
                }else{
                    this.raiz = new DefaultMutableTreeNode(name + " songs");
                }
                this.DB = new db();
                break;
            case 2:
                if("EN".equals(lang)){
                    this.raiz = new DefaultMutableTreeNode("Album: " + name);
                }else{
                    this.raiz = new DefaultMutableTreeNode("Disco: " + name);
                }
                this.DB = new db();
                break;
        }
        
    }
    
    /**
     * 
     * Fill node tree with all songs, ordered by name.
     */
    public void fill_song_names(){
        List <Cancion> c = DB.get_canciones();
        gui.st_canciones = c;
        for(Cancion can: c){
            DefaultMutableTreeNode song = new DefaultMutableTreeNode();
            song.setUserObject(can.getNombre());
            raiz.add(song);
        }
        modelo = new DefaultTreeModel(raiz);
        gui.jTree1.setModel(modelo);
    }
    
    /**
     * 
     * User Search: Fill node tree with songs, filered by name.
     * @param nombre 
     */
    public void fill_song_names_by_name(String nombre){
        List <Cancion> c = DB.get_canciones(nombre);
        gui.st_canciones = c;
        for(Cancion can: c){
            DefaultMutableTreeNode song = new DefaultMutableTreeNode();
            song.setUserObject(can.getNombre());
            raiz.add(song);
        }
        modelo = new DefaultTreeModel(raiz);
        gui.jTree1.setModel(modelo);
    }
    
    /**
     * 
     * Fill node tree with songs, filered by autor id.
     * @param id_autor 
     */
    public void fill_song_names_by_autor(int id_autor){
        List <Cancion> c = DB.get_canciones_autor(id_autor);
        gui.st_canciones = c;
        for(Cancion can: c){
            DefaultMutableTreeNode song = new DefaultMutableTreeNode();
            song.setUserObject(can.getNombre());
            raiz.add(song);
        }
        modelo = new DefaultTreeModel(raiz);
        gui.jTree1.setModel(modelo);
    }
    
    /**
     * 
     * Fill node tree with songs, filered by gendre.
     * @param genero 
     */
    public void fill_song_names_by_gendre(String genero){
        List <Cancion> c = DB.get_canciones_genero(genero);
        gui.st_canciones = c;
        for(Cancion can: c){
            DefaultMutableTreeNode song = new DefaultMutableTreeNode();
            song.setUserObject(can.getNombre());
            raiz.add(song);
        }
        modelo = new DefaultTreeModel(raiz);
        gui.jTree1.setModel(modelo);
    }
    
    /**
     * Shows album image and fills node tree with songs from album.
     * @param id_disco 
     */
    public void fill_song_names_by_album(int id_disco){
        List <Cancion> c = DB.get_canciones_disco(id_disco);
        gui.st_canciones = c;
        for(Cancion can: c){
            DefaultMutableTreeNode song = new DefaultMutableTreeNode();
            song.setUserObject(can.getNombre());
            raiz.add(song);
        }
        modelo = new DefaultTreeModel(raiz);
        gui.jTree1.setModel(modelo);
        
        jLabel_album_img.setIcon(DB.get_disco_img(c.get(1).getId_disco()));
    }
}
