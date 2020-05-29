
package runcoderrun;

import java.io.File;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;





public class MusicPlayer implements Runnable{
    InputStream music;
    AudioStream audio;
    Thread t;
    boolean alive = true;
    AudioPlayer musicPlayer = AudioPlayer.player;
    AudioInputStream audioInput;
    Clip clip;
    File musicPath;
    long clipTimePos;
    String file_path;


    public MusicPlayer(String path){
        
        try{
            file_path= path;
            musicPath = new File(file_path);
            if(musicPath.exists()){
                audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);  
            }
                
        
        }catch(Exception e){
            e.printStackTrace();
        }
        

            
    }
    
    
    public void run() {
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        System.out.println("Running"); 
    }
    
    
    public synchronized void play(){
        t = new Thread(this);
        clip.setMicrosecondPosition(clipTimePos);
        t.start();
    }
    
    public synchronized void pause(){
        clipTimePos = clip.getMicrosecondPosition();
        clip.stop();
    }
    
    public synchronized void resume(){
        clip.setMicrosecondPosition(clipTimePos);
        clip.start();
    }
    
     
    
    public synchronized void stop(){
        clip.stop();
        System.out.println("Died");
        t.interrupt();
        try {
            t.join();
	} catch (InterruptedException e) {}
    }
    
    public void setFile(String path){
        this.file_path = path;
    }  
}
