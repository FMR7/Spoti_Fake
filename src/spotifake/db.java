package spotifake;

import Pojos.Autor;
import Pojos.Cancion;
import Pojos.Disco;
import Pojos.Grupo;
import fmr.persistence.ConfigFiles;

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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 * @since V 0.1
 */
public class db {

    private String host , port, database, user, pass;
    private String dbConnection;
    
    private String songsFolder;
    private String imgsFolder;
    
    Connection conexion;
    PreparedStatement s;
    ResultSet rs;
    
    /**
     * 
     * Default constructor.
     */
    public db(){
        Properties newProperties = new Properties();
        newProperties.setProperty("HOST", "127.0.0.1");
        newProperties.setProperty("PORT", "3306");
        newProperties.setProperty("DB", "musica");
        newProperties.setProperty("USER", "root");
        newProperties.setProperty("PASS", "");

        ConfigFiles cf = new ConfigFiles();
        cf.newFile("DB_Data", newProperties, "Database connection data.");

        Properties loadFile = cf.loadFile("DB_Data", true);
        if(loadFile != null){
            this.host = loadFile.getProperty("HOST");
            this.port = loadFile.getProperty("PORT");
            this.database = loadFile.getProperty("DB");
            this.user = loadFile.getProperty("USER");
            this.pass = loadFile.getProperty("PASS");

            this.dbConnection = "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database;
        }else{
            JOptionPane.showMessageDialog(null, "Connection DB data file not found: DB_Data.conf");
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select h.songsFolder, h.imgsFolder from hostfolders h");
            rs = s.executeQuery();

            while(rs.next())
            {
                songsFolder = rs.getString(1);
                imgsFolder = rs.getString(2);
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //CANCIONES
    /**
     * 
     * @return All songs in a List.
     */
    public List<Cancion> get_canciones(){
        List <Cancion> c = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select c.* from canciones c order by c.nombre");
            rs = s.executeQuery();

            while(rs.next())
            {
                c.add(new Cancion(rs.getInt(1),rs.getString(2), rs.getInt(3), songsFolder + rs.getString(4), rs.getInt(5), rs.getString(6)));
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
    
    /**
     * 
     * @param id
     * @return The song with the given id
     */
    public Cancion get_cancion(int id){
        Cancion c = null;
        
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select * from canciones where id = ?");
            s.setInt(1, id);
            rs = s.executeQuery();

            while(rs.next())
            {
                c = (new Cancion(rs.getInt(1),rs.getString(2), rs.getInt(3), songsFolder + rs.getString(4), rs.getInt(5), rs.getString(6)));
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
    
    /**
     * 
     * @param id_disco
     * @return All songs of the given album id in a List.
     */
    public List<Cancion> get_canciones_disco(int id_disco){
        List <Cancion> c = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select * from v_canciones_disco where id_disco = ?");
            s.setInt(1, id_disco);
            rs = s.executeQuery();

            while(rs.next())
            {
                c.add(new Cancion(rs.getInt(1),rs.getString(2), rs.getInt(3), songsFolder + rs.getString(4), rs.getInt(5), rs.getString(6)));
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
    
    /**
     * 
     * @param id_autor
     * @return All songs of the given author id in a List.
     */
    public List<Cancion> get_canciones_autor(int id_autor){
        List <Cancion> c = new ArrayList<>();
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select * from v_canciones_autor where id_autor = ?");
            s.setInt(1, id_autor);
            rs = s.executeQuery();

            while(rs.next())
            {
                c.add(new Cancion(rs.getInt(1),rs.getString(2), rs.getInt(3), songsFolder + rs.getString(4), rs.getInt(5), rs.getString(6)));
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
    
    /**
     * 
     * @param genero
     * @return All songs of the given genre in a List.
     */
    public List<Cancion> get_canciones_genero(String genero){
        List <Cancion> c = new ArrayList<>();
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select * from v_canciones_genero where genero = ?");
            s.setString(1, genero);
            rs = s.executeQuery();

            while(rs.next())
            {
                c.add(new Cancion(rs.getInt(1),rs.getString(2), rs.getInt(3), songsFolder + rs.getString(4), rs.getInt(5), rs.getString(6)));
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
    /**
     * 
     * @return All groups in a List.
     */
    public List<Grupo> get_grupos(){
        List <Grupo> g = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select * from grupos");
            rs = s.executeQuery();

            while(rs.next())
            {
                g.add(new Grupo(rs.getInt(1),rs.getString(2)));
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
    
    /**
     * 
     * @param id_cancion
     * @return The group of the given album id of the song.
     */
    public String get_grupo(int id_cancion){
        String str = "";
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select * from v_grupo_cancion where id_disco = ? limit 1");
            s.setInt(1, id_cancion);
            rs = s.executeQuery();

            while(rs.next())
            {
                str = rs.getString(1);
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
        
        return(str);
    }
    
    //DISCOS
    /**
     * 
     * @param id_grupo
     * @return All albums of the given group id in a List.
     */
    public List<Disco> get_discos_grupo(int id_grupo){
        List <Disco> d = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select id, nombre, fecha, url_img from v_discos_grupo where id_grupo = ?");
            s.setInt(1, id_grupo);
            rs = s.executeQuery();

            while(rs.next())
            {
                d.add(new Disco(rs.getInt(1), rs.getString(2), rs.getDate(3), imgsFolder + rs.getString(4)));
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
    
    /**
     * 
     * @return All albums in a List.
     */
    public List<Disco> get_discos(){
        List <Disco> d = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select d.id, d.nombre, d.fecha, d.url_img from discos d");
            rs = s.executeQuery();

            while(rs.next())
            {
                d.add(new Disco(rs.getInt(1), rs.getString(2), rs.getDate(3), imgsFolder + rs.getString(4)));
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
    
    /**
     * 
     * @param id_disco
     * @return The album image of the given album id.
     */
    public Icon get_disco_img(int id_disco){
        ImageIcon icon = null;
        String url = "";
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select d.url_img from discos d where d.id = ?");
            s.setInt(1, id_disco);
            rs = s.executeQuery();

            while(rs.next())
            {
                url = imgsFolder + rs.getString(1);
            }
            System.out.println(url);
            if(!"".equals(url)){
                URL url1 = new URL(url);
                BufferedImage img = ImageIO.read(url1);
                Image dimg = img.getScaledInstance(292, 292, Image.SCALE_SMOOTH);
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
    
    /**
     * 
     * @param id_cancion
     * @return The name of the album that contains the given song id.
     */
    public String get_disco_nombre(int id_cancion){
        String d = "";
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select * from v_disco_nombre where id_cancion = ?");
            s.setInt(1, id_cancion);
            rs = s.executeQuery();

            while(rs.next())
            {
                d = rs.getString(1);
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
    
    //AUTORES
    /**
     * 
     * @return All authors in a List.
     */
    public List<Autor> get_autores(){
        List <Autor> a = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select a.id, a.nombre from autores a");
            rs = s.executeQuery();

            while(rs.next())
            {
                a.add(new Autor(rs.getInt(1), rs.getString(2)));
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
    
    /**
     * 
     * @param id_cancion
     * @return The authors of the given song id in a List.
     */
    public String get_autores(int id_cancion){
        List <String> a = new ArrayList<>();
        String str = "";
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select * from v_autores_cancion where id_cancion = ?");
            s.setInt(1, id_cancion);
            rs = s.executeQuery();

            while(rs.next())
            {
                a.add(rs.getString(1));
            }
            
            for(int i = 1; i <= a.size(); i++){
                if(i == a.size()){
                    str += a.get(i-1) + ".";
                }else{
                    str += a.get(i-1) + ", ";
                }
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
        
        return(str);
    }
    
    //GENEROS
    /**
     * 
     * @return All genres in a List.
     */
    public List<String> get_generos(){
        List <String> a = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select c.genero FROM canciones c group by c.genero");
            rs = s.executeQuery();

            while(rs.next())
            {
                a.add(rs.getString(1));
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
    
    //BUSQUEDA
    /**
     * 
     * @param nombre
     * @return All songs in a List, filered by name.
     */
    public List<Cancion> get_canciones(String nombre){
        List <Cancion> c = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select c.id, c.nombre, c.id_disco, c.url, c.rating, c.genero from canciones c where c.nombre like ?");
            s.setString(1, "%" + nombre + "%");
            rs = s.executeQuery();

            while(rs.next())
            {
                c.add(new Cancion(rs.getInt(1),rs.getString(2), rs.getInt(3), songsFolder + rs.getString(4), rs.getInt(5), rs.getString(6)));
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

    /**
     * 
     * @param nombre
     * @return All albums in a List, filered by name.
     */
    public List<Disco> get_discos(String nombre){
        List <Disco> d = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select d.id, d.nombre, d.fecha, d.url_img from discos d where d.nombre like ?");
            s.setString(1, "%" + nombre + "%");
            rs = s.executeQuery();

            while(rs.next())
            {
                d.add(new Disco(rs.getInt(1), rs.getString(2), rs.getDate(3), imgsFolder + rs.getString(4)));
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
    
    /**
     * 
     * @param nombre
     * @return All genres in a List, filered by name.
     */
    public List<String> get_generos(String nombre){
        List <String> a = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select c.genero FROM canciones c where c.genero like ? group by c.genero");
            s.setString(1, "%" + nombre + "%");
            rs = s.executeQuery();

            while(rs.next())
            {
                a.add(rs.getString(1));
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
    
    /**
     * 
     * @param nombre
     * @return All groups in a List, filered by name.
     */
    public List<Grupo> get_grupos(String nombre){
        List <Grupo> g = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select * from grupos where nombre like ?");
            s.setString(1, "%" + nombre + "%");
            rs = s.executeQuery();

            while(rs.next())
            {
                g.add(new Grupo(rs.getInt(1),rs.getString(2)));
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
    
    /**
     * 
     * @param nombre
     * @return All authors in a List, filered by name.
     */
    public List<Autor> get_autores(String nombre){
        List <Autor> a = new ArrayList<>();
        
        try{
            conexion = DriverManager.getConnection(this.dbConnection, this.user, this.pass);
            s = conexion.prepareStatement("select a.id, a.nombre from autores a where a.nombre like ?");
            s.setString(1, "%" + nombre + "%");
            rs = s.executeQuery();

            while(rs.next())
            {
                a.add(new Autor(rs.getInt(1), rs.getString(2)));
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
