import javax.sound.sampled.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.net.StandardSocketOptions;
import java.util.*;

public class PlayMusic {
    int index;
    Long currentFrame;
    Clip clip;
    String status;
    AudioInputStream audioInputStream;
    String filePath;
    String data[];
    public PlayMusic(String data[],String filePath)
    {
        this.filePath=filePath;
        this.data=data;
        index=0;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        }
        catch (Exception e)
        {
            System.out.println("error6"+e);
        }

    }

    public void play()
    {
        try {
            clip.start();
            status = "play";
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception e){
            System.out.println("error5"+e);
        }
    }
    public void pause()
    {
        if (status.equals("paused"))
        {
            System.out.println("audio is already paused");
            return;
        }
        this.currentFrame = this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }
    public void resumeAudio()
    {
        try {

            if (status.equals("play")) {
                System.out.println("Audio is already being played");
                return;
            }
            clip.close();
            resetAudioStream();
            clip.setMicrosecondPosition(currentFrame);
            this.play();
        }
        catch (Exception e)
        {
            System.out.println("error4"+e);
        }
    }
    public void resetAudioStream()
    {
        try {


            audioInputStream = AudioSystem.getAudioInputStream(
                    new File(filePath).getAbsoluteFile());
            clip.open(audioInputStream);
        }
        catch (Exception e)
        {
            System.out.println("error3"+e);
        }
    }
    public void stop()
    {
        try {


            currentFrame = 0L;
            clip.stop();
            clip.close();
        }
        catch (Exception e){
            System.out.println("error2"+e);
        }
    }
    public void nextsong()
    {
        index++;

        try {
            if (index>data.length-1)
            {
                index=0;
            }
            String b="A:\\songs\\"+data[index]+".wav";
            audioInputStream = AudioSystem.getAudioInputStream(new File(b).getAbsoluteFile());
            clip.close();
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            this.play();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            status="nextsong";
        }
        catch (Exception e)
        {
            System.out.println("error"+e);
        }

    }
    void gotoChoice(int c)
    {
        try {

            switch (c) {
                case 1:
                    play();
                    break;
                case 2:
                    pause();
                    break;
                case 3:
                    resumeAudio();
                    break;
                case 4:
                    nextsong();

                    break;
                case 5:
                    stop();
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.println(e+" ' There is no More Song in PlayList ' ");
        }

    }


}
