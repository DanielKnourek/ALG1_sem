package cz.tul.knourekdaniel.present;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CustomConsole {
    private JFrame frame = new JFrame("So this is Christmas");
    private JTextArea console;
    private Boolean[] keyPressed = new Boolean[]{false,false,false,false};
    public CustomConsole(){
        
        frame.setSize(1200,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        console = new JTextArea();
        console.setBackground(Color.BLACK);
        console.setCaretColor(Color.WHITE);
        console.setForeground(Color.WHITE);
        console.setFont(Font.getFont(Font.SERIF));        
        
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
                print("Keykode: ");
                print(keyEvent.getKeyCode()+"");
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                
            }
        };
    }

    public void print(String text){
        console.setText(text);
    }
    
}
