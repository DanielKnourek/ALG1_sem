package cz.tul.knourekdaniel.ALG.project.dev;

import java.awt.*;

public class AciiPainter {
    char[][] CurrentView;
    private Point dimensions;
    int cursor = 1;

    public AciiPainter(int height){
        dimensions = new Point(height*5,height);
        this.CurrentView = new char[dimensions.y][dimensions.x];
        for (int row = 0; row < CurrentView.length; row++) {
            for (int col = 0; col < CurrentView[0].length; col++) {
                CurrentView[ row ][ col ] = '-';
            }
        }
    }

    private void Draw() {
        String Frame = "";
        for (int row = 0; row < this.CurrentView.length; row++) {
            String Line = "";
            for (int col = 0; col < this.CurrentView[0].length; col++) {
                Line += this.CurrentView[ row ][ col ] ;
            }
            Frame += Line + "\n";
        }
//        System.out.printf("%s %n",Frame);
        System.out.printf(((char) 0x1b) + "[1A\r" + "%s", Frame);
//        System.out.print("\r"+Frame );
    }

    public void Move() {
//        this.CurrentView[cursor%25][cursor%125] = ' ';
//        cursor++; cursor++;

        Draw();

    }

    public void Load(String[] animation, Point start){
        Point cursor = start;
        while (cursor.y < this.dimensions.y) {
            cursor.x = start.x;
//            if (cursor.y >= this.dimensions.y){ break;}
            while (cursor.x < this.dimensions.x){
                this.CurrentView[cursor.y-start.y][cursor.x-start.y] = animation[cursor.y].charAt(cursor.x);
                cursor.x++;
            }
            cursor.y++;
        }
        Draw();
    }
}
