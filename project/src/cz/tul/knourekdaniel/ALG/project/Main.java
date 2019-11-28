package cz.tul.knourekdaniel.ALG.project;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        AciiPainter painter = new AciiPainter(25);
        Timer Tick = new Timer();
        ProcessBuilder clear = new ProcessBuilder("cmd", "/c", "cls").inheritIO();
//        ProcessBuilder clear = new ProcessBuilder("powershell", "Clear-Host").inheritIO();
        Tick.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
//                    Runtime.getRuntime().exec("cls");
//                    Runtime.getRuntime().exec("clear");
                        clear.start(). waitFor();
                        painter.Move();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }

//
//                System.out.printf(((char) 0x1b) + "[1A\r" + "Item 1: %d ", progress1[0]);
//                System.out.printf(((char) 0x1b) + "[1C\r" + "Item 2: %d ", progress1[1]);
//                progress1[0]++;
//                progress1[1]--;
            }
        },1,50);

    }
}
