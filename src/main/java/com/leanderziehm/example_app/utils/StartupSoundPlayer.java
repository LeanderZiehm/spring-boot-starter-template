package com.leanderziehm.example_app.utils;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.sound.sampled.*;

import java.net.URL;

@Component
public class StartupSoundPlayer {

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        playSound("sparkle.wav");
    }

    private void playSound(String fileName) {
        try {
            URL soundUrl = getClass().getResource("/sound/" + fileName);
           
            if (soundUrl == null) {
                throw new IllegalStateException("Sound file not found: " + fileName);
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundUrl);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}