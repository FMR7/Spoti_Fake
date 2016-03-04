package spotifake;

import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import resources.icons.img;
import static spotifake.gui.jLabel1;

/**
 *
 * @author Fernando
 */
public class Player extends Thread{
    private Media m;
    private MediaPlayer mp;
    private String curr_song;
    
    private boolean audio;
    private boolean isPlaying;
    
    private final img im;
    
    public Player() {
        this.curr_song = "";
        this.audio = true;
        this.isPlaying = false;
        this.im = new img();
    }
    
    public boolean isPlaying() {
        return isPlaying;
    }
    
    public void mute(){
        if(audio == true){
            gui.jButton4.setIcon((ImageIcon) im.ini("mute.png"));
            mp.setMute(true);
            audio = false;
        }else{
            gui.jButton4.setIcon((ImageIcon) im.ini("unmute.png"));
            mp.setMute(false);
            audio = true;
        }
    }
    
    public void set_song(String song_url){
        curr_song = song_url;
        m = new Media(Paths.get(song_url).toUri().toString());
        mp = new MediaPlayer(m);
        play_song();
        jLabel1.setText(curr_song);
    }
    
    //SET SONG REMOTE
    public void set_song_remote(String song_url) throws UnsupportedEncodingException {
        if(isPlaying()){
            stop_song();
        }
        curr_song = song_url;
        
        //Replace " " by "%20"
        String s[] = curr_song.split(" ");
        if(s.length > 1){
            String nueva = "";
            for(int i = 0; i < s.length; i++){
                if(i == s.length-1){
                    nueva += s[i]; 
                }else{
                    nueva += s[i] + "%20";
                }
            }
            m = new Media(nueva);
            gui.jLabel1.setText(nueva);
        }else
        {
            m = new Media(curr_song);
            gui.jLabel1.setText(curr_song);
        }
        
        
        mp = new MediaPlayer(m);
        play_song();
    }
    
    //PLAY
    public void play_song(){
        if(!"".equals(curr_song)){
           mp.play();
           isPlaying = true;
           gui.jToggleButton1.setIcon((ImageIcon) im.ini("pause_s.png"));
           gui.jToggleButton1.setSelected(true);
        }
        else{
            gui.jToggleButton1.doClick();
            JOptionPane.showMessageDialog(null, "Select an audio file.");
        }
        
    }
    
    //PAUSE
    public void pause_song(){
        if(isPlaying){
           mp.pause();
           isPlaying = false;
        }
    }
    
    //STOP
    public void stop_song(){
        if(!"".equals(curr_song)){
            mp.stop();
            isPlaying = false;
            gui.jToggleButton1.setIcon((ImageIcon) im.ini("play_s.png"));
            gui.jToggleButton1.setSelected(false);
            curr_song = "";
        }
    }
    
    //NEXT SONG
    //PREVIOUS SONG
    
    
}
