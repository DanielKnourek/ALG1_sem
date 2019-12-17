package cz.tul.knourekdaniel.ALG.project.dev;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FileLoader {
    String Animations;
    InputStream inputStream;
    BufferedReader reader;

    public ArrayList<String[]> load(){

        try {
            String folder = "Animations";
            String file ="src/cz/tul/knourekdaniel/ALG/project/" + folder;
            ArrayList<String[]> animation = new ArrayList<>();
            int height = 20;

            reader = new BufferedReader(new FileReader(file));
            String currentLine;

            while ((currentLine = reader.readLine()) != null){
                int numberOfFrames = Integer.parseInt(currentLine);
                animation.add(loadAnimation(numberOfFrames));
            }
            reader.close();
            return animation;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    private String[] loadAnimation(int numberOfFrames) {
        String[] Animation = new String[numberOfFrames];
        for (int frame = 0; frame < numberOfFrames; frame++) {
            int numberOfLines = Integer.parseInt(getLine());
            Animation[frame] = loadFrame(numberOfLines);
        }
        return Animation;
    }

    private String loadFrame(int numberOfLines) {
        StringBuilder frame = new StringBuilder();
        for (int currentLine = 0; currentLine < numberOfLines; currentLine++) {
            frame.append(getLine()+"\n");
        }
         return frame.toString();
    }

    private String getLine() {
        try {
            String line;
            if ((line = reader.readLine()) == null){
                line = null;
            }
            return line;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
