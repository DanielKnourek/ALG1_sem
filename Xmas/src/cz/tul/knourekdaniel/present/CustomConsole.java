package cz.tul.knourekdaniel.present;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CustomConsole {
    private JFrame frame = new JFrame("So this is Christmas");
    private JTextArea console;
    private Boolean[] keyPressed = new Boolean[]{false,false,false,false};
    public Point direction = new Point(0,0);
    public CustomConsole(){
        
        frame.setSize(1200,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        console = new JTextArea();
        console.setBackground(Color.BLACK);
        console.setCaretColor(Color.WHITE);
        console.setForeground(Color.WHITE);
//        console.setFont(Font.getFont(Font.DIALOG));        
//        console.setFont(new Font("TimesRoman", Font.PLAIN, 18));        
        console.setFont(new Font("Monospaced", Font.PLAIN, 12));
//        label.setFont(new Font("Courier New", Font.PLAIN, 12)));
        
        frame.add(console);
        
        setKeyListener();
        frame.setVisible(true);
    }

    private void setKeyListener() {
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
//                System.out.println(keyEvent.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
//                print("Keykode"+keyEvent.getKeyCode());
                switch (keyEvent.getKeyCode()){
                    //W up
                    case 87:
                    case 38:
                        direction.y = -1;
                        break;
                    //S down
                    case 83:
                    case 40:
                        direction.y = 1;
                        break;
                    //A left
                    case 65:
                    case 37:
                        direction.x = -1;
                        break;
                    //D right
                    case 68:
                    case 39:
                        direction.x = 1;
                        break;                        
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()){
                    //W up
                    case 87:
                    case 38:
                    //S down
                    case 83:
                    case 40:
                        direction.y = 0;
                        break;
                    //A left
                    case 65:
                    case 37:
                    //D right
                    case 68:
                    case 39:
                        direction.x = 0;
                        break;
                }
            }
        };
        console.addKeyListener(listener);
    }

    public void print(String text){
        console.setText(text);
    }
    public void append(String text){
        console.append(text);
    }
    
}
