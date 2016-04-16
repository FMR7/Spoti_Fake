package spotifake;

import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import resources.icons.img;
import static spotifake.gui.jLabel_album_img;

/**
 *
 * @author Fernando
 * @since V 0.3
 */
public class Player extends Thread{
    private Media m;
    private MediaPlayer mp;
    private String curr_song;
    
    private boolean audio;
    private boolean isPlaying;
    
    private final img im;
    
    /**
     * 
     * Default constructor.
     */
    public Player() {
        this.curr_song = "";
        this.audio = true;
        this.isPlaying = false;
        this.im = new img();
    }
    
    /**
     * 
     * @return Player status, isPlaying.
     */
    public boolean isPlaying() {
        return isPlaying;
    }
    
    /**
     * 
     * User action: Mute and unmute.
     */
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
    
    /**
     * 
     * Used to set a remote song.
     * @param song_url
     * @throws UnsupportedEncodingException 
     */
    public void set_song_remote(String song_url) throws UnsupportedEncodingException {
        if(!song_url.equals(curr_song)){//Evita reproducir la misma canción al hacerle clic.
            if(isPlaying()){//Si está sonando la para.
                stop_song();
            }
            curr_song = song_url;
            
            //Format string
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
                gui.jLabel_song_name.setText(nueva);
            }else
            {
                m = new Media(curr_song);
                gui.jLabel_song_name.setText(curr_song);
            }


            mp = new MediaPlayer(m);
            play_song();
        }
    }
    
    /**
     * 
     * User action: Used when playing a new song and when returning from a paused song.
     */
    public void play_song(){
        if(!"".equals(curr_song)){
            mp.play();
            isPlaying = true;
            gui.jToggleButton1.setIcon((ImageIcon) im.ini("pause_s.png"));
            gui.jToggleButton1.setSelected(true);
            
            //EVENTS
            //Run next song
            mp.setOnEndOfMedia(new Runnable() {
                @Override
                public void run() {
                    gui.set_next_song();
                }
            });
            
            //Get song duration
            mp.setOnReady(new Runnable() {
                @Override
                public void run() {
                    int mins = (int) m.getDuration().toMinutes();
                    int secs = (int) (m.getDuration().toSeconds()%60);
                    
                    String s_mins = mins + "";
                    String s_secs = secs + "";
                    
                    if(s_secs.length() == 1){
                        s_secs = "0" + s_secs;
                    }
                    if(s_mins.length() == 1){
                        s_mins = "0" + s_mins;
                    }
                    
                    String total_time = s_mins + ":" + s_secs;
                    
                    gui.jLabel_song_duration.setText(total_time + "");
                }
            });
        }
        else{
            gui.jToggleButton1.doClick();
            JOptionPane.showMessageDialog(null, "Select a song from the list.");
        }
        
    }
    
    /**
     * 
     * User action: Used when user pause a song.
     */
    public void pause_song(){
        if(isPlaying){
           mp.pause();
           isPlaying = false;
        }
    }
    
    /**
     * 
     * User action: Used when user stops a song.
     */
    public void stop_song(){
        if(!"".equals(curr_song)){
            mp.stop();
            isPlaying = false;
            gui.jToggleButton1.setIcon((ImageIcon) im.ini("play_s.png"));
            gui.jToggleButton1.setSelected(false);
            curr_song = "";
        }
    }
}
