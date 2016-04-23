package Dao;

import Pojos.Disco;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import spotifake.db;
import spotifake.gui;

/**
 *
 * @author Fernando
 * @since V 0.4
 */
public class Dao_discos {
    private DefaultMutableTreeNode raiz;
    private DefaultTreeModel modelo;
    private db DB;

    /**
     * 
     * Default constructor.
     */
    public Dao_discos() {
        this.raiz = new DefaultMutableTreeNode("\\");
        this.DB = new db();
    }
    
    /**
     * 
     * Used to show all albums of an author.
     * @param name 
     */
    public Dao_discos(String name) {
        this.raiz = new DefaultMutableTreeNode(name);
        this.DB = new db();
    }
    
    /**
     * 
     * Fill node tree with all albums.
     */
    public void fill_album_names(){
        List <Disco> d = DB.get_discos();
        gui.st_discos = d;
        for(Disco dis: d){
            DefaultMutableTreeNode song = new DefaultMutableTreeNode();
            song.setUserObject(dis.getNombre());
            raiz.add(song);
        }
        modelo = new DefaultTreeModel(raiz);
        gui.jTree1.setModel(modelo);
    }
    
    /**
     * 
     * Fill node tree with albums of a specific group.
     * @param id 
     */
    public void fill_album_names_by_group(int id){
        List <Disco> d = DB.get_discos_grupo(id);
        gui.st_discos = d;
        for(Disco dis: d){
            DefaultMutableTreeNode song = new DefaultMutableTreeNode();
            song.setUserObject(dis.getNombre());
            raiz.add(song);
        }
        modelo = new DefaultTreeModel(raiz);
        gui.jTree1.setModel(modelo);
    }
    
    /**
     * 
     * User Search: Fill node tree with specific group albums, filered by name.
     * @param nombre 
     */
    public void fill_album_names_by_name(String nombre){
        List <Disco> d = DB.get_discos(nombre);
        gui.st_discos = d;
        for(Disco dis: d){
            DefaultMutableTreeNode song = new DefaultMutableTreeNode();
            song.setUserObject(dis.getNombre());
            raiz.add(song);
        }
        modelo = new DefaultTreeModel(raiz);
        gui.jTree1.setModel(modelo);
    }
}
