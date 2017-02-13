import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Alex on 27.01.2017.
 * This project mini-program created for setting time work with PC
 *
 */

public class TimerForWork {


    private static Scanner sc = new Scanner(System.in);
    private static String s;
    static int i ;
    private static Timer timer;

    public static void main (String [] args)  {

        System.out.print("Enter number in min: ");
        while (true) {
            s = sc.nextLine();
            try {
                i = Integer.parseInt(s);
                break;
            } catch (Exception e) {
                System.err.println("input error ");
                System.out.print("try again inputting only a numbers: ");
            }
        }
        i = i * 60;
        timer = new Timer();
        timer.schedule(new Task(), 0,1000);
    }
    private static class Task extends TimerTask {
        @Override
        public void run() {
            System.out.println(i);
            i--;
            if (i <= 0) {
                timer.cancel();

                AePlayWave wav = new AePlayWave(); // here we open our class where the sound is process
                wav.start();
            }
        }
    }
}
