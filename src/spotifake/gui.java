package spotifake;

import Dao.Dao_autores;
import Dao.Dao_canciones;
import Dao.Dao_discos;
import Dao.Dao_generos;
import Dao.Dao_grupos;
import Pojos.Autor;
import Pojos.Cancion;
import Pojos.Disco;
import Pojos.Grupo;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import resources.icons.img; //import images for the gui

/**
 *
 * @author Fernando
 */
public class gui extends javax.swing.JFrame {
    public static int current_song_id = 1;
    
    public static List<Cancion> st_canciones;
    public static List<Grupo> st_grupos;
    public static List <Disco> st_discos;
    public static List <Autor> st_autores;
    public static List <String> st_generos;
    
    public static boolean showing_discos = false;
    public static boolean showing_songs = false;
    public static boolean showing_autores = false;
    
    img im = new img(); //load images for the gui
    
    String track_list[]; //array de strings con las direcciones de las canciones
    List<String> urls = new ArrayList<>();
    
    Player ply;
    
    public gui() {
        
        initComponents();
        
        try {
            setIconImage(getToolkit().getImage(getClass().getResource("/resources/icons/play_s.png")));
            
            jButton1.setOpaque(false);
            jButton1.setContentAreaFilled(false);
            jButton1.setBorderPainted(false);
            jButton1.setIcon((ImageIcon) im.ini("stop_s.png"));

            jToggleButton1.setOpaque(false);
            jToggleButton1.setContentAreaFilled(false);
            jToggleButton1.setBorderPainted(false);
            jToggleButton1.setIcon((ImageIcon) im.ini("play_s.png"));
            
            jButton2.setOpaque(false);
            jButton2.setContentAreaFilled(false);
            jButton2.setBorderPainted(false);
            jButton2.setIcon((ImageIcon) im.ini("back_s.png"));
            
            jButton3.setOpaque(false);
            jButton3.setContentAreaFilled(false);
            jButton3.setBorderPainted(false);
            jButton3.setIcon((ImageIcon) im.ini("next_s.png"));
            
            jButton4.setOpaque(false);
            jButton4.setContentAreaFilled(false);
            jButton4.setBorderPainted(false);
            jButton4.setIcon((ImageIcon) im.ini("unmute.png"));
            
            jComboBox1.setSelectedIndex(0);
            
            this.ply = new Player();
            
        } catch (Exception ex) {
            System.out.println("WARNING CAN'T LOAD RESOURCES");
            ex.printStackTrace();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jSlider2 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SpotiFake");
        setMinimumSize(new java.awt.Dimension(569, 376));
        setResizable(false);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jButton1.setMaximumSize(new java.awt.Dimension(70, 70));
        jButton1.setMinimumSize(new java.awt.Dimension(70, 70));
        jButton1.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setMaximumSize(new java.awt.Dimension(70, 70));
        jButton2.setMinimumSize(new java.awt.Dimension(70, 70));
        jButton2.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setMaximumSize(new java.awt.Dimension(70, 70));
        jButton3.setMinimumSize(new java.awt.Dimension(70, 70));
        jButton3.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jToggleButton1.setMaximumSize(new java.awt.Dimension(70, 70));
        jToggleButton1.setMinimumSize(new java.awt.Dimension(70, 70));
        jToggleButton1.setPreferredSize(new java.awt.Dimension(70, 70));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBar(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel1);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Search...");
        jTextField1.setToolTipText("");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Album image here");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jButton4.setPreferredSize(new java.awt.Dimension(23, 23));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jSlider2.setValue(0);

        jLabel2.setText("00:00/00:00");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Canciones", "Grupos", "Autores", "Discos", "Generos" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Open audio file");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("View");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Tools");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Help");

        jMenuItem2.setText("About");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jComboBox1, 0, 190, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(55, 55, 55)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSlider2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //FUNCTIONS INI ------------------------------------------------------------
    
    
    //EDITABLE SONG PROGRESS BAR
    
    //SEARCH, switch combobox
    public void search(String s)
    {
        
    }

    public void clear_tree(){
        DefaultTreeModel modelo = null;
        jTree1.setModel(modelo);
    }
    //FUNCTIONS END ------------------------------------------------------------
    
    
    
    
    
    //EVENTS INI _______________________________________________________________
    //Play/Pause
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if(jToggleButton1.isSelected() == true)
        {
            jToggleButton1.setIcon((ImageIcon) im.ini("pause_s.png"));
            ply.play_song();
        }
        else
        {
            jToggleButton1.setIcon((ImageIcon) im.ini("play_s.png"));
            ply.pause_song();
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    //Previous song
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(current_song_id != 1){
            try {
                ply.set_song_remote(st_canciones.get(current_song_id-2).getUrl());
                jLabel1.setText("   " + st_canciones.get(current_song_id-2).getNombre());
                
                jLabel1.setIcon(new db().get_disco_img(st_canciones.get(current_song_id-2).getId_disco()));
                
                current_song_id = current_song_id-1;
                jTree1.setSelectionRow(current_song_id);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    //Stop
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ply.stop_song();
    }//GEN-LAST:event_jButton1ActionPerformed

    //Next song
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(current_song_id != st_canciones.size()){
            try {
                ply.set_song_remote(st_canciones.get(current_song_id).getUrl());
                jLabel1.setText("   " + st_canciones.get(current_song_id).getNombre());
                
                jLabel1.setIcon(new db().get_disco_img(st_canciones.get(current_song_id).getId_disco()));
                
                current_song_id = current_song_id+1;
                jTree1.setSelectionRow(current_song_id);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    //Select local file
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fc.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            File selfile = fc.getSelectedFile();
            System.out.println("Selected file: " + selfile);
            ply.set_song(selfile.toString());
            if(jToggleButton1.isSelected() == false)
            {
                jToggleButton1.doClick();
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    //About
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    //Mute
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ply.mute();
    }//GEN-LAST:event_jButton4ActionPerformed

    //NOT FINISHED
    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
        // TODO add your handling code here:
        String str1 = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());
        System.out.println("\nComboBox: " + str1);
        TreePath tp = jTree1.getSelectionPath().getParentPath();
        switch(str1){
            case "Canciones": //Finish
                if(tp == null){ //It's the root node

                }else{ //It's a song
                    try {
                        String str = jTree1.getSelectionModel().getSelectionPath().toString(); //Devuelve "[Canciones, CANCION]"
                        String s[] = str.split(","); //SPLIT, Nos quedamos con " CANCION]"
                        String n = s[1].substring(1, s[1].length()-1); //Cogemos "CANCION"
                        System.out.println("Clicked Song: " + n);
                        
                        int[] sel = jTree1.getSelectionModel().getSelectionRows();
                        int sel_id = st_canciones.get(sel[0]-1).getId();
                        current_song_id = jTree1.getSelectionRows()[0];
                        
                        //Play clicked song
                        Cancion c = new db().get_cancion(sel_id);
                        ply.set_song_remote(c.getUrl());
                        jLabel1.setText("   " + c.getNombre());
                        
                        jLabel1.setIcon(new db().get_disco_img(c.getId_disco()));
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                break;
            case "Grupos": //Not Finish
                if(tp == null){ //It's the root node

                }else{ 
                    if(showing_discos == false){
                        String str = jTree1.getSelectionModel().getSelectionPath().toString();
                        String s[] = str.split(",");
                        String n = s[1].substring(1, s[1].length()-1);
                        System.out.println("Clicked Group: " + n);
                        System.out.println("Albums:");
                        
                        int[] sel = jTree1.getSelectionModel().getSelectionRows();
                        int sel_id = st_grupos.get(sel[0]-1).getId();

                        //List<Disco> d = new db().get_discos_grupo(sel_id);
                        new Dao_discos(n).fill_album_names_by_group(sel_id);
                        showing_discos = true;
                    }else{ //Show album songs in main panel <---------------------------------
                        if(showing_songs == false){
                            String str = jTree1.getSelectionModel().getSelectionPath().toString();
                            String s[] = str.split(",");
                            String n = s[1].substring(1, s[1].length()-1);
                            System.out.println("Clicked Album: " + n);

                            int[] sel = jTree1.getSelectionModel().getSelectionRows();
                            int sel_id = st_discos.get(sel[0]-1).getId();

                            new Dao_canciones(n,2).fill_song_names_by_album(sel_id);
                            showing_songs = true;
                        }else{
                            try {
                            String str = jTree1.getSelectionModel().getSelectionPath().toString(); //Devuelve "[Canciones, CANCION]"
                            String s[] = str.split(","); //SPLIT, Nos quedamos con " CANCION]"
                            String n = s[1].substring(1, s[1].length()-1); //Cogemos "CANCION"
                            System.out.println("Clicked Song: " + n);
                            
                            int[] sel = jTree1.getSelectionModel().getSelectionRows();
                            int sel_id = st_canciones.get(sel[0]-1).getId();
                            current_song_id = jTree1.getSelectionRows()[0];
                            
                            //Play clicked song
                            Cancion c = new db().get_cancion(sel_id);
                            ply.set_song_remote(c.getUrl());
                            jLabel1.setText("   " + c.getNombre());
                            
                            jLabel1.setIcon(new db().get_disco_img(c.getId_disco()));
                        } catch (UnsupportedEncodingException ex) {
                            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                    }
                }
                break;
            case "Autores": //Finish
                if(tp == null){ //It's the root node

                }else{ 
                    if(showing_autores == false){
                        String str = jTree1.getSelectionModel().getSelectionPath().toString();
                        String s[] = str.split(",");
                        String n = s[1].substring(1, s[1].length()-1);
                        System.out.println("Clicked Autor: " + n);
                        
                        int[] sel = jTree1.getSelectionModel().getSelectionRows();
                        int sel_id = st_autores.get(sel[0]-1).getId();
                        
                        new Dao_canciones(n,1).fill_song_names_by_autor(sel_id);
                        showing_autores = true;
                    } else{
                        try {
                            String str = jTree1.getSelectionModel().getSelectionPath().toString(); //Devuelve "[Canciones, CANCION]"
                            String s[] = str.split(","); //SPLIT, Nos quedamos con " CANCION]"
                            String n = s[1].substring(1, s[1].length()-1); //Cogemos "CANCION"
                            System.out.println("Clicked Song: " + n);
                            
                            int[] sel = jTree1.getSelectionModel().getSelectionRows();
                            int sel_id = st_canciones.get(sel[0]-1).getId();
                            current_song_id = jTree1.getSelectionRows()[0];
                            
                            //Play clicked song
                            Cancion c = new db().get_cancion(sel_id);
                            ply.set_song_remote(c.getUrl());
                            jLabel1.setText("   " + c.getNombre());
                            
                            jLabel1.setIcon(new db().get_disco_img(c.getId_disco()));
                        } catch (UnsupportedEncodingException ex) {
                            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
                break;
            case "Discos": //Finish
                if(tp == null){

                }else{ 
                    if(showing_discos == false){
                        String str = jTree1.getSelectionModel().getSelectionPath().toString();
                        String s[] = str.split(",");
                        String n = s[1].substring(1, s[1].length()-1);
                        System.out.println("Clicked Album: " + n);
                        
                        int[] sel = jTree1.getSelectionModel().getSelectionRows();
                        int sel_id = st_discos.get(sel[0]-1).getId();
                        
                        new Dao_canciones(n,2).fill_song_names_by_album(sel_id);
                        showing_discos = true;
                    } else{
                        try {
                            String str = jTree1.getSelectionModel().getSelectionPath().toString(); //Devuelve "[Canciones, CANCION]"
                            String s[] = str.split(","); //SPLIT, Nos quedamos con " CANCION]"
                            String n = s[1].substring(1, s[1].length()-1); //Cogemos "CANCION"
                            System.out.println("Clicked Song: " + n);
                            
                            int[] sel = jTree1.getSelectionModel().getSelectionRows();
                            int sel_id = st_canciones.get(sel[0]-1).getId();
                            current_song_id = jTree1.getSelectionRows()[0];
                            
                            //Play clicked song
                            Cancion c = new db().get_cancion(sel_id);
                            ply.set_song_remote(c.getUrl());
                            jLabel1.setText("   " + c.getNombre());

                            jLabel1.setIcon(new db().get_disco_img(c.getId_disco()));
                        } catch (UnsupportedEncodingException ex) {
                            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }   
                }
                break;
            case "Generos": //Finish
                if(tp == null){ //It's the root node

                }else{ 
                    if(showing_autores == false){
                        String str = jTree1.getSelectionModel().getSelectionPath().toString();
                        String s[] = str.split(",");
                        String n = s[1].substring(1, s[1].length()-1);
                        System.out.println("Clicked genero: " + n);
                        
                        int[] sel = jTree1.getSelectionModel().getSelectionRows();
                        String sel_gen = st_generos.get(sel[0]-1);
                        
                        new Dao_canciones(n,1).fill_song_names_by_genere(sel_gen);
                        showing_autores = true;
                    } else{
                        try {
                            String str = jTree1.getSelectionModel().getSelectionPath().toString(); //Devuelve "[Canciones, CANCION]"
                            String s[] = str.split(","); //SPLIT, Nos quedamos con " CANCION]"
                            String n = s[1].substring(1, s[1].length()-1); //Cogemos "CANCION"
                            System.out.println("Clicked Song: " + n);
                            
                            int[] sel = jTree1.getSelectionModel().getSelectionRows();
                            int sel_id = st_canciones.get(sel[0]-1).getId();
                            current_song_id = jTree1.getSelectionRows()[0];
                            
                            //Play clicked song
                            Cancion c = new db().get_cancion(sel_id);
                            ply.set_song_remote(c.getUrl());
                            jLabel1.setText("   " + c.getNombre());
                            
                            jLabel1.setIcon(new db().get_disco_img(c.getId_disco()));
                        } catch (UnsupportedEncodingException ex) {
                            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
                break;
            default:
                
                break;
            
        }
    }//GEN-LAST:event_jTree1MouseClicked

    //Search clear
    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        showing_discos = false;
        showing_autores = false;
        showing_songs = false;
        
        String s = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());
        System.out.println("\nComboBox: " + s);
        clear_tree();
        switch(s){
            case "Canciones":
                new Dao_canciones().fill_song_names();
                
                break;
            case "Grupos":
                new Dao_grupos().fill_group_names();
                
                break;
            case "Autores":
                new Dao_autores().fill_autor_names();
                
                break;
            case "Discos":
                new Dao_discos().fill_album_names();
                
                break;
            case "Generos":
                new Dao_generos().fill_genero_names();
                
                break;
            default:
                
                break;
            
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    
    //EVENTS END _______________________________________________________________
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
        
        
    }//END MAIN
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox<String> jComboBox1;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JSlider jSlider2;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JToggleButton jToggleButton1;
    public static javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
