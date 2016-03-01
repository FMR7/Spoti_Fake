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
 */
public class Dao_discos {
    private DefaultMutableTreeNode raiz;
    private DefaultTreeModel modelo;
    private db DB;

    public Dao_discos() {
        this.raiz = new DefaultMutableTreeNode("Discos");
        this.DB = new db();
    }
    
    public Dao_discos(String name) {
        this.raiz = new DefaultMutableTreeNode("Discos: " + name);
        this.DB = new db();
    }
    
    //Fill node tree with all albums
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
    
    //Fill node tree with specific group albums
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
}
