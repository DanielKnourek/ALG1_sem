package cz.tul.knourekdaniel.present;

import java.awt.*;
import java.util.Arrays;

public class AciiPainter {
    private final String StringUtils = new String();
    private String[] CurrentView;
    public Point dimensions;
    public CustomConsole console;

    public AciiPainter(int height) {
        dimensions = new Point(height * 10, height);
        this.CurrentView = new String[height];

        for (int row = 0; row < this.CurrentView.length; row++) {
            this.CurrentView[row] = String.format("%" + this.dimensions.x + "s", "");
        }
        if (Main.customConsole) {
            console = new CustomConsole();
        }
    }

    public void Load(String[] animation, Point start) {
        Point cursor = start;
        for (String line : animation) {
            replace(cursor, line);
            cursor.y++;
        }
    }

    public void Draw() {
        StringBuilder out = new StringBuilder();
        for (String line : this.CurrentView) {
            out.append(line).append("\n");
        }
        if (Main.customConsole) {
            console.print(out.toString());
        } else {
            System.out.println(out.toString());
        }
    }

    public void setChar(Point point, char ch) {
        StringBuilder str = new StringBuilder(this.CurrentView[point.y]);
        str.setCharAt(point.x, ch);
        this.CurrentView[point.y] = str.toString();
    }

    private void replace(Point point, String string) {
        StringBuilder str = new StringBuilder(this.CurrentView[point.y]);
        str.replace(point.x, point.x + string.length(), string);
        this.CurrentView[point.y] = str.toString();
    }
}
