package cz.tul.knourekdaniel.present;

import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class Animator {
    private int Time = 0;
    private ArrayList<String[][]> Animations = new ArrayList<>();
    private AciiPainter painter;
    private int skore = 0;
    Animator(){
        painter = new AciiPainter(20);
        FileLoader fl = new FileLoader();
        Animations.add(fl.load("/res/Santa"));
        Animations.add(fl.load("/res/Sky"));
        if (Main.pretty){
            Animations.add(new String[][]{{" \t\uD83C\uDF81  "}});
        }else{
            Animations.add(new String[][]{{"─┼─"}});
        }
        Animations.add(fl.load("/res/Chimney"));
        Chimneys();
        painter.Draw();
    }

    private void Load(String[][] frame, int x, int y){
        painter.Load(frame[Time % frame.length], new Point(x,y));
    }

    private Point crossPos = new Point(60,10);

    public void Move(){
        for (int i = 5; i > 0; i--) {
            Load(Animations.get(1), i*40 - Time % 40,0); //sky
        }
        Load(Animations.get(0),0,0); //santa
        if (Time % ((Main.difficulty+1)*20) == 0){
            newChimney();
        }
        Chimneys();
        Load(Animations.get(2), this.crossPos.x, this.crossPos.y); // cross
        painter.Draw();
        this.Time++;
        if (Time % 1 == 0){
            MoveCursor(painter.console.direction);
        }
        painter.console.append("Dárků rozdáno: "+ this.skore);
    }
    
    public void MoveCursor(Point direction){
        if (this.crossPos.x < painter.dimensions.x - 40 && direction.x > 0){ this.crossPos.x++;}
        if (this.crossPos.x > 45 && direction.x < 0){ this.crossPos.x -= 2;}
        if (this.crossPos.y < painter.dimensions.y-2 && direction.y > 0){ this.crossPos.y++;}
        if (this.crossPos.y > 1 && direction.y < 0){ this.crossPos.y--;}
        Chimneys.removeIf(chimney -> (CheckCursor(chimney,this.crossPos)));
    }
    public boolean CheckCursor(Point chimney, Point cross){
        boolean overalapsX = (cross.x > chimney.x && cross.x < chimney.x+3);
        boolean overalapsY = (cross.y > chimney.y-2 && cross.y < chimney.y+2);
        if ((overalapsX && overalapsY)){
            this.skore++;
            return true;	
        }
        return false;
    }
    
    private Random rnd = new Random();
    private ArrayList<Point> Chimneys = new ArrayList<>();
    private void Chimneys(){
        ArrayList<Point> tmp = Chimneys;
        for (Point point: tmp) {
            Load(Animations.get(3), point.x, point.y); // chimneys
            point.x--;
        }
        Chimneys.removeIf(n -> (n.x < 40));
//        int index = 0;
//        ArrayList<Integer> indexes = new ArrayList<Integer>();
//        for (Point point: Chimneys) {
//            Load(Animations.get(3), point.x, point.y); // chimneys
//            point.x--;
//            if (point.x < 40){
//                indexes.add(index);
//            }
//            index++;
//        }
//        for (int i: indexes) {
//            Chimneys.remove(i);
//        }
    }
    private void newChimney(){
        Chimneys.add(new Point(200,rnd.nextInt(4*4)));
    }
    
    
}