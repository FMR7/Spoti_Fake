package spotifake;

import Pojos.Autor;
import Pojos.Cancion;
import Pojos.Disco;
import Pojos.Grupo;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class db {

    private final String host, port, database, user, pass;
    
    Connection conexion;
    PreparedStatement s;
    ResultSet rs;
    
    public db(){
        this.host = "127.0.0.1";
        this.port = "3306";
        this.database = "musica";
        this.user = "root";
        this.pass = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //CANCIONES
    //OK
    public List<Cancion> get_canciones(){
        List <Cancion> c = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, pass);
            s = conexion.prepareStatement("select * from canciones");
            rs = s.executeQuery();

            while(rs.next())
            {
                c.add(new Cancion(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
            
            for(int i = 0; i < c.size(); i++){
                System.out.println("\nID: " + c.get(i).getId());
                System.out.println(" Nombre: " + c.get(i).getNombre());
                System.out.println(" ID_Disco: " + c.get(i).getId_disco());
                System.out.println(" URL: " + c.get(i).getUrl());
                System.out.println(" Rating: " + c.get(i).getRating());
                System.out.println(" Genero: " + c.get(i).getGenero());
            }
            rs.close();
            s.close();
            conexion.close();
        }
        catch(SQLException ex){
            System.out.println("WARNING: No connection to DB.");
            JOptionPane.showMessageDialog(null, "No connection to DB.");
            ex.printStackTrace();
        }
        
        return(c);
    }
    
    //OK
    public Cancion get_cancion(int id){
        Cancion c = null;
        
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, pass);
            s = conexion.prepareStatement("select * from canciones where id = ?");
            s.setInt(1, id);
            rs = s.executeQuery();

            while(rs.next())
            {
                c = (new Cancion(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }

            System.out.println("\nID: " + c.getId());
            System.out.println(" Nombre: " + c.getNombre());
            System.out.println(" ID_Disco: " + c.getId_disco());
            System.out.println(" URL: " + c.getUrl());
            System.out.println(" Rating: " + c.getRating());
            System.out.println(" Genero: " + c.getGenero());
            
            rs.close();
            s.close();
            conexion.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return(c);
    }
    
    //OK
    public List<Cancion> get_canciones_disco(int id_disco){
        List <Cancion> c = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, pass);
            s = conexion.prepareStatement("select c.* from discos d join canciones c ON d.id = c.id_disco where d.id = ?");
            s.setInt(1, id_disco);
            rs = s.executeQuery();

            while(rs.next())
            {
                c.add(new Cancion(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
            System.out.println("\nCanciones del disco: ");
            for(int i = 0; i < c.size(); i++){
                System.out.println("ID: " + c.get(i).getId());
                System.out.println(" Nombre: " + c.get(i).getNombre());
                System.out.println(" ID_Disco: " + c.get(i).getId_disco());
                System.out.println(" URL: " + c.get(i).getUrl());
                System.out.println(" Rating: " + c.get(i).getRating());
                System.out.println(" Genero: " + c.get(i).getGenero());
            }
            rs.close();
            s.close();
            conexion.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return(c);
    }
    
    //OK
    public List<Cancion> get_canciones_autor(int id_autor){
        List <Cancion> c = new ArrayList<>();
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, pass);
            s = conexion.prepareStatement("select c.* from autores_canciones ac "
                    + "inner join autores a ON ac.id_autor = a.id "
                    + "inner join canciones c ON ac.id_cancion = c.id where a.id = ?");
            s.setInt(1, id_autor);
            rs = s.executeQuery();

            while(rs.next())
            {
                c.add(new Cancion(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
            
            for(int i = 0; i < c.size(); i++){
                System.out.println("\nID: " + c.get(i).getId());
                System.out.println(" Nombre: " + c.get(i).getNombre());
                System.out.println(" ID_Disco: " + c.get(i).getId_disco());
                System.out.println(" URL: " + c.get(i).getUrl());
                System.out.println(" Rating: " + c.get(i).getRating());
                System.out.println(" Genero: " + c.get(i).getGenero());
            }
            rs.close();
            s.close();
            conexion.close();
        }
        catch(SQLException ex){
            System.out.println("WARNING: No connection to DB.");
            JOptionPane.showMessageDialog(null, "No connection to DB.");
            ex.printStackTrace();
        }
        
        return(c);
    }
    
    //GRUPOS
    //OK
    public List<Grupo> get_grupos(){
        List <Grupo> g = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, pass);
            s = conexion.prepareStatement("select * from grupos");
            rs = s.executeQuery();

            while(rs.next())
            {
                g.add(new Grupo(rs.getInt(1),rs.getString(2)));
            }
            
            for(int i = 0; i < g.size(); i++){
                System.out.println("\nID: " + g.get(i).getId());
                System.out.println(" Nombre: " + g.get(i).getNombre());
            }
            rs.close();
            s.close();
            conexion.close();
        }
        catch(SQLException ex){
            System.out.println("WARNING: No connection to DB.");
            JOptionPane.showMessageDialog(null, "No connection to DB.");
            ex.printStackTrace();
        }
        
        return(g);
    }
    
    //DISCOS
    //OK
    public List<Disco> get_discos_grupo(int id_grupo){
        List <Disco> d = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, pass);
            s = conexion.prepareStatement("select d.id, d.nombre, d.fecha, d.url_img from grupos_discos gd inner join grupos g ON gd.id_grupo = g.id inner join discos d ON gd.id_disco = d.id where g.id = ?");
            s.setInt(1, id_grupo);
            rs = s.executeQuery();

            while(rs.next())
            {
                d.add(new Disco(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4)));
            }
            
            for(int i = 0; i < d.size(); i++){
                System.out.println("\nID: " + d.get(i).getId());
                System.out.println(" Nombre: " + d.get(i).getNombre());
                System.out.println(" Fecha: " + d.get(i).getFecha());
                System.out.println(" URL img: " + d.get(i).getUrl_img());
            }
            rs.close();
            s.close();
            conexion.close();
        }
        catch(SQLException ex){
            System.out.println("WARNING: No connection to DB.");
            JOptionPane.showMessageDialog(null, "No connection to DB.");
            ex.printStackTrace();
        }
        
        return(d);
    }
    
    //OK
    public List<Disco> get_discos(){
        List <Disco> d = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, pass);
            s = conexion.prepareStatement("select d.id, d.nombre, d.fecha, d.url_img from discos d");
            rs = s.executeQuery();

            while(rs.next())
            {
                d.add(new Disco(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4)));
            }
            
            for(int i = 0; i < d.size(); i++){
                System.out.println("\nID: " + d.get(i).getId());
                System.out.println(" Nombre: " + d.get(i).getNombre());
                System.out.println(" Fecha: " + d.get(i).getFecha());
                System.out.println(" URL img: " + d.get(i).getUrl_img());
            }
            rs.close();
            s.close();
            conexion.close();
        }
        catch(SQLException ex){
            System.out.println("WARNING: No connection to DB.");
            JOptionPane.showMessageDialog(null, "No connection to DB.");
            ex.printStackTrace();
        }
        
        return(d);
    }
    
    //OK
    public Icon get_disco_img(int id){
        ImageIcon icon = null;
        String url = "";
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, pass);
            s = conexion.prepareStatement("select d.url_img from discos d where d.id = ?");
            s.setInt(1, id);
            rs = s.executeQuery();

            while(rs.next())
            {
                url = rs.getString(1);
            }
            
            System.out.println("IMG_URL: \"" + url + "\"");
            
            if(!"".equals(url)){
                URL url1 = new URL(url);
                BufferedImage img = ImageIO.read(url1);
                Image dimg = img.getScaledInstance(64, 64, Image.SCALE_SMOOTH);
                icon = new ImageIcon(dimg);
            }
            rs.close();
            s.close();
            conexion.close();
        }
        catch(SQLException ex){
            System.out.println("WARNING: No connection to DB.");
            JOptionPane.showMessageDialog(null, "No connection to DB.");
            ex.printStackTrace();
        } catch (MalformedURLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return(icon);
    }
    
    //AUTORES
    //OK
    public List<Autor> get_autores(){
        List <Autor> a = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, pass);
            s = conexion.prepareStatement("select a.id, a.nombre from autores a");
            rs = s.executeQuery();

            while(rs.next())
            {
                a.add(new Autor(rs.getInt(1), rs.getString(2)));
            }
            
            for(int i = 0; i < a.size(); i++){
                System.out.println("\nID: " + a.get(i).getId());
                System.out.println(" Nombre: " + a.get(i).getNombre());
            }
            rs.close();
            s.close();
            conexion.close();
        }
        catch(SQLException ex){
            System.out.println("WARNING: No connection to DB.");
            JOptionPane.showMessageDialog(null, "No connection to DB.");
            ex.printStackTrace();
        }
        
        return(a);
    }
    
    
}
