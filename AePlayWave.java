import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

class AePlayWave extends Thread {

    /**
     * HERE WE INSTALL SOUND WHICH WILL BE PLAYED IN THE END OF THE TIMER
     */

    AePlayWave()
    {
        for (int y = 0; y < 10; y ++) {
            try {
                File soundFile = new File("res/set.wav"); // here we specify way to audio file
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                FloatControl vc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                vc.setValue(-10);
                clip.setFramePosition(0);
                clip.start();
                Thread.sleep(clip.getMicrosecondLength() / 1000);
                clip.stop();
            } catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
                exc.printStackTrace();
            } catch (InterruptedException ignored) { }
        }
    }
}