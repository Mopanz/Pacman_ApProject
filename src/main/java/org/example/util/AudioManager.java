package org.example.util;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import javax.print.DocFlavor;


public class AudioManager {

    private static AudioManager instance;

    private MediaPlayer mainMusic;

    private AudioClip ghostSound;
    private AudioClip pelletSound;
    private AudioClip gameOverSound;

    private boolean musicOn;
    private boolean soundOn;

    private AudioManager(){
        loadResources();
        musicOn = true;
        soundOn = true;
    }

    public static AudioManager getInstance(){
        if (instance == null){
            instance = new AudioManager();
        }
        return instance;
    }

    private void loadResources(){

        try {
            if (getClass().getResource("/Sounds/Main_music.mp3") != null){
                mainMusic = new MediaPlayer(new Media(getClass().getResource("/Sounds/Main_music.mp3").toString()));
                mainMusic.setCycleCount(MediaPlayer.INDEFINITE);
                mainMusic.setVolume(0.1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ghostSound = new AudioClip(getClass().getResource("/Sounds/GhostSound.mp3").toString());
        ghostSound.setCycleCount(AudioClip.INDEFINITE);
        ghostSound.setVolume(0.2);

        pelletSound = new AudioClip(getClass().getResource("/Sounds/PelletSound.mp3").toString());
        pelletSound.setVolume(0.3);

        gameOverSound = new AudioClip(getClass().getResource("/Sounds/GameOverSound.mp3").toString());
        gameOverSound.setVolume(0.5);


    }

    public void playMainMusic(){
        if (mainMusic != null && musicOn){
            mainMusic.play();
        }
    }

    public void pauseMainMusic(){
        mainMusic.pause();
    }

    public void stopMainMusic(){
        mainMusic.stop();
    }

    public void playGhostSound(){
        if (ghostSound != null && soundOn && !ghostSound.isPlaying()){
            ghostSound.play();
        }
    }

    public void pauseGhostSound(){
        ghostSound.stop();
    }

    public void playPelletSound(){
        if (pelletSound != null && soundOn){
            pelletSound.play();
        }
    }

    public void playGameOverSound(){
        if (gameOverSound != null && soundOn){
            gameOverSound.play();
        }
    }

    public boolean isMusicOn() {
        return musicOn;
    }

    public void onMusic(){
        musicOn = true;
    }

    public void offMusic(){
        musicOn = false;
    }

    public boolean isSoundOn() {
        return soundOn;
    }

    public void onSound(){
        soundOn = true;
    }

    public void offSound(){
        soundOn = false;
    }
}
