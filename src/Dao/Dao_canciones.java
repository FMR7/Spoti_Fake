package Dao;

import Pojos.Cancion;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import spotifake.db;
import spotifake.gui;

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
    
    
    //Fill node tree with songs
    public void fill_song_names(){
        List <Cancion> c = DB.get_canciones();
        for(Cancion can: c){
            DefaultMutableTreeNode song = new DefaultMutableTreeNode();
            song.setUserObject(can.getNombre());
            raiz.add(song);
        }
        modelo = new DefaultTreeModel(raiz);
        gui.jTree1.setModel(modelo);
    }
}
