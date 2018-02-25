package model;

import java.io.IOException;
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.JSlider;

public class Song {

    public File file;
    public Clip clip;
    public long numOfFrames;

    public Song(File file) {

        this.file = file;

        /* specify the sound to manipulated
        (assuming the sound can be played by the audio system)
        from a wave File */
        
        try {
            if (file.exists()) {
                AudioInputStream sound = AudioSystem.getAudioInputStream(file); //gets audio from file
                clip = AudioSystem.getClip();
                clip.open(sound);

            }
            else {
                throw new RuntimeException("Sound: file not found: " + this.file);
            }
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
	public void rewind(){
        clip.setFramePosition(0);
	}
    
    public void play(){
        clip.start();
    }

    public void stop(){
        clip.stop();
    }
}
