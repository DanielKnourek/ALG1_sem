package cz.tul.knourekdaniel.ALG.project.dev;

import java.awt.*;
import java.util.ArrayList;

public class Animator {

    Animator(){
        AciiPainter painter = new AciiPainter(20);
        FileLoader fl = new FileLoader();
        ArrayList<String[]> Animations = fl.load();
        painter.Load(Animations.get(0),new Point(0,0));
    }
}
