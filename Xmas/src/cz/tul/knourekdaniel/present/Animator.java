package cz.tul.knourekdaniel.present;

import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;

public class Animator {
    private int Time = 0;
    private ArrayList<String[][]> Animations = new ArrayList<>();
    private AciiPainter painter;
    private Point crossPos = new Point(60,10);

    Animator(){
        painter = new AciiPainter(20);
        FileLoader fl = new FileLoader();
        Animations.add(fl.load("/res/Santa"));
        Animations.add(fl.load("/res/Sky"));
        Animations.add(new String[][]{{"─┼─"}});
        Animations.add(fl.load("/res/Chimney"));
        painter.Draw();
    }

    private void Load(String[][] frame, int x, int y){
        painter.Load(frame[Time % frame.length], new Point(x,y));
    }
    
    public void Move(){
        for (int i = 5; i > 0; i--) {
            Load(Animations.get(1), i*40 - Time % 40,0); //sky
        }
        Load(Animations.get(0),0,0); //santa
        Load(Animations.get(3), 60, 2); // chimney
        Load(Animations.get(2), this.crossPos.x, this.crossPos.y); // cross
        painter.Draw();
        this.Time++;
    }
    public void Move(Point direction){
        if (direction.x > 0){ this.crossPos.x++;}
        if (direction.x < 0){ this.crossPos.x--;}
        if (direction.y > 0){ this.crossPos.y++;}
        if (direction.y < 0){ this.crossPos.y--;}
    }
    
    
}