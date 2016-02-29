package spotifake;

import Pojos.Cancion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public Cancion get_cancion(String nombre){
        Cancion c = null;
        
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, pass);
            s = conexion.prepareStatement("select * from canciones where nombre = ?");
            s.setString(1, nombre);
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
    public List<Cancion> get_canciones_disco(String nombre_disco){
        List <Cancion> c = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, pass);
            s = conexion.prepareStatement("select c.* from canciones c, discos d where d.nombre = ?");
            s.setString(1, nombre_disco);
            rs = s.executeQuery();

            while(rs.next())
            {
                c.add(new Cancion(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
            System.out.println("\nCanciones del disco: " + nombre_disco);
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
    
    
}
