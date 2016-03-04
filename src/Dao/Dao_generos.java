package Dao;

import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import spotifake.db;
import spotifake.gui;

/**
 *
 * @author Fernando
 */
public class Dao_generos {

    private DefaultMutableTreeNode raiz;
    private DefaultTreeModel modelo;
    private db DB;

    public Dao_generos() {
        this.raiz = new DefaultMutableTreeNode("Géneros");
        this.DB = new db();
    }
    
    //Fill node tree with groups
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
    
    
}
