package Dao;

import Pojos.Cancion;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import spotifake.db;
import spotifake.gui;
import static spotifake.gui.jLabel1;

/**
 *
 * @author Fernando
 */
public class Dao_canciones {
    private DefaultMutableTreeNode raiz;
    private DefaultTreeModel modelo;
    private db DB;
    
    
    public Dao_canciones() {
        this.raiz = new DefaultMutableTreeNode("Canciones");
        this.DB = new db();
    }
    
    public Dao_canciones(String name, int n) {
        switch (n){
            case 1:
                this.raiz = new DefaultMutableTreeNode("Canciones de " + name);
                this.DB = new db();
                break;
            case 2:
                this.raiz = new DefaultMutableTreeNode("Album: " + name);
                this.DB = new db();
                break;
        }
        
    }
    
    //Fill node tree with songs
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
    
    //Fill node tree with songs
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
    
    //Fill node tree with songs
    public void fill_song_names_by_genere(String genero){
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
    
    //ADD ALBUM IMG by id_disco
    //Fill node tree with songs
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
        
        jLabel1.setIcon(DB.get_disco_img(c.get(1).getId_disco()));
    }
}
