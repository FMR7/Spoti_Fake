package spotifake;

import Pojos.Cancion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class db {

    private final String host, port, database, user, pass;
    
    Connection conexion;
    Statement s;
    ResultSet rs;
    
    public db(){
        this.host = "127.0.0.1";
        this.port = "3306";
        this.database = "musica";
        this.user = "root";
        this.pass = "";
    }
    
    public List<Cancion> get_canciones(){
        List <Cancion> c = new ArrayList<>();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, pass);
            s = conexion.createStatement();
            rs = s.executeQuery("select * from canciones");

            while(rs.next())
            {
                c.add(new Cancion(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
            
            for(int i = 0; i < c.size(); i++){
                System.out.print("\nID: " + c.get(i).getId());
                System.out.print(" Nombre: " + c.get(i).getNombre());
                System.out.print(" ID_Disco: " + c.get(i).getId_disco());
                System.out.println(" URL: " + c.get(i).getUrl());
                System.out.println(" Rating: " + c.get(i).getRating());
                System.out.println(" Genero: " + c.get(i).getGenero());
            }
            
        }
        catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        
        return(c);
    }
    
    public List<Cancion> get_canciones_disco(String nombre_disco){
        List <Cancion> c = new ArrayList<>();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, pass);
            s = conexion.createStatement();
            rs = s.executeQuery("select * from canciones");

            while(rs.next())
            {
                c.add(new Cancion(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
            
            for(int i = 0; i < c.size(); i++){
                System.out.print("\nID: " + c.get(i).getId());
                System.out.print(" Nombre: " + c.get(i).getNombre());
                System.out.print(" ID_Disco: " + c.get(i).getId_disco());
                System.out.println(" URL: " + c.get(i).getUrl());
                System.out.println(" Rating: " + c.get(i).getRating());
                System.out.println(" Genero: " + c.get(i).getGenero());
            }
            
        }
        catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        
        return(c);
    }
}
