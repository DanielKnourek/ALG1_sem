package cz.tul.knourekdaniel.ALG.project;

public class AciiPainter {
    char[][] CurrentView;
    int cursor = 1;

    public AciiPainter(int height){
        this.CurrentView = new char[height][height*5];

        for (int row = 0; row < CurrentView.length; row++) {
            for (int col = 0; col < CurrentView[0].length; col++) {
                CurrentView[ row ][ col ] = '-';
            }
        }


        Draw();
    }

    private void Draw() {
        String Frame = "";
        for (int row = 0; row < CurrentView.length; row++) {
            String Line = "";
            for (int col = 0; col < CurrentView[0].length; col++) {
                Line += CurrentView[ row ][ col ] ;
            }
            Frame += Line + "\n";
        }
//        System.out.printf("%s %n",Frame);
        System.out.printf(((char) 0x1b) + "[1A\r" + "%s", Frame);
//        System.out.print("\r"+Frame );
    }

    public void Move() {
        CurrentView[cursor%25][cursor%125] = ' ';
        cursor++; cursor++;
        Draw();

    }
}
