package cz.tul.knourekdaniel.present;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static boolean customConsole = true;
    public static boolean pretty = false;
    public static int difficulty = 5;
    public static int clocl = 0;
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        customConsole = (!checkParameter(args,"nogui"));
        pretty = (checkParameter(args,"pretty"));
        difficulty = (checkParameter(args,"0")? 10 : difficulty);
        difficulty = (checkParameter(args,"1")? 5 : difficulty);
        difficulty = (checkParameter(args,"2")? 1 : difficulty);
        Animator scene = new Animator();
        Timer(scene);


//        System.out.println(System.getProperty("user.dir").toString());
    }

    private static boolean checkParameter(String[] args, String type) {
        boolean enabled = false;
        for (String parameter: args) {
            enabled = enabled || parameter.equals(type);
        }
        return enabled;
    }

    private static void Timer(Animator scene) {
        Timer Tick = new Timer();
        ProcessBuilder clear = new ProcessBuilder("cmd", "/c", "cls").inheritIO();
//        ProcessBuilder clear = new ProcessBuilder("powershell", "Clear-Host").inheritIO();
        Tick.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scene.Move();
                if (!customConsole) {
                    try {
                        clear.start().waitFor();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 1, ((difficulty >= 5 ) ? 50: 20));
    }
}
