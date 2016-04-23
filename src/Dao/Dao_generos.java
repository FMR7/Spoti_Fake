package Dao;

import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import spotifake.db;
import spotifake.gui;

/**
 *
 * @author Fernando
 * @since V 0.7
 */
public class Dao_generos {

    private DefaultMutableTreeNode raiz;
    private DefaultTreeModel modelo;
    private db DB;

    /**
     * 
     * Default constructor.
     */
    public Dao_generos() {
        this.raiz = new DefaultMutableTreeNode("\\");
        this.DB = new db();
    }
    
    /**
     * 
     * Fill node tree with groups.
     */
    public void fill_genero_names(){
        List <String> gen = DB.get_generos();
        gui.st_generos = gen;
        for(String ge: gen){
            DefaultMutableTreeNode song = new DefaultMutableTreeNode();
            song.setUserObject(ge);
            raiz.add(song);
        }
        modelo = new DefaultTreeModel(raiz);
        gui.jTree1.setModel(modelo);
    }
    
    /**
     * 
     * User Search: Fill node tree with groups, filtered by gendre.
     * @param genero 
     */
    public void fill_genero_names_by_genero(String genero){
        List <String> gen = DB.get_generos(genero);
        gui.st_generos = gen;
        for(String ge: gen){
            DefaultMutableTreeNode song = new DefaultMutableTreeNode();
            song.setUserObject(ge);
            raiz.add(song);
        }
        modelo = new DefaultTreeModel(raiz);
        gui.jTree1.setModel(modelo);
    }
}
