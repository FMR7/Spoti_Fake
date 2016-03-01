package Dao;

import Pojos.Grupo;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import spotifake.db;
import spotifake.gui;

/**
 *
 * @author Fernando
 */
public class Dao_grupos {
    private DefaultMutableTreeNode raiz;
    private DefaultTreeModel modelo;
    private db DB;
    
    
    public Dao_grupos() {
        this.raiz = new DefaultMutableTreeNode("Grupos");
        this.DB = new db();
    }
    
    
    //Fill node tree with groups
    public void fill_group_names(){
        List <Grupo> grp = DB.get_grupos();
        gui.st_grupos = grp;
        for(Grupo gr: grp){
            DefaultMutableTreeNode song = new DefaultMutableTreeNode();
            song.setUserObject(gr.getNombre());
            raiz.add(song);
        }
        modelo = new DefaultTreeModel(raiz);
        gui.jTree1.setModel(modelo);
    }
}
