package Dao;

import Pojos.Autor;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import spotifake.db;
import spotifake.gui;

/**
 *
 * @author Fernando
 */
public class Dao_autores {
    private DefaultMutableTreeNode raiz;
    private DefaultTreeModel modelo;
    private db DB;

    public Dao_autores() {
        this.raiz = new DefaultMutableTreeNode("Autores");
        this.DB = new db();
    }
    
    //Fill node tree with songs
    public void fill_autor_names(){
        List <Autor> a = DB.get_autores();
        gui.st_autores = a;
        for(Autor aut: a){
            DefaultMutableTreeNode song = new DefaultMutableTreeNode();
            song.setUserObject(aut.getNombre());
            raiz.add(song);
        }
        modelo = new DefaultTreeModel(raiz);
        gui.jTree1.setModel(modelo);
    }
    
    //SEARCH
    //Fill node tree with songs
    public void fill_autor_names_by_name(String nombre){
        List <Autor> a = DB.get_autores(nombre);
        gui.st_autores = a;
        for(Autor aut: a){
            DefaultMutableTreeNode song = new DefaultMutableTreeNode();
            song.setUserObject(aut.getNombre());
            raiz.add(song);
        }
        modelo = new DefaultTreeModel(raiz);
        gui.jTree1.setModel(modelo);
    }
}
