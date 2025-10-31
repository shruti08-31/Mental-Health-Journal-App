package PRIYANSHU.Audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AudioPlayer {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("C:\\Users\\skpri\\Downloads\\Missed My Chance - The Grey Room _ Clark Sims.wav");
        Scanner input = new Scanner(System.in) ;
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        String response ="";
        while (!response.equalsIgnoreCase("q")){
            System.out.println("P = Play , S = Stop , R = Reset, Q = Quit");
            System.out.println("Enter your choice:");
            response = input.next();
            response = response.toUpperCase();
            switch (response){
                case "P" :
                    clip.start();
                    break;
                case "R":
                    clip.setMicrosecondPosition(0);
                    break;
                case "S":
                    clip.stop();
                    break;
                default:
                    System.out.println("Enter valid choise!");
            }
        }
    }

}
