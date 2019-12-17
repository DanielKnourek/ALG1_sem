package cz.tul.knourekdaniel.present;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FileLoader {
    String Animations;
    InputStream inputStream;
    BufferedReader reader;
    String path = System.getProperty("user.dir");

    public String[][] load(String fileName){

        try {
            String file;
//            if (path == "T:\\Můj disk\\TUL\\1 ZS_ALG\\Seminarka\\Xmas"){
            if (!path.matches("(.*)jar(.*)")){
            file ="src/cz/tul/knourekdaniel/present" + fileName;
            }else{
            file = path + fileName;
            }

            String[][] animation = new String[0][];
            int height = 20;

            reader = new BufferedReader(new FileReader(file));
            String currentLine;

            while ((currentLine = reader.readLine()) != null){
                int numberOfFrames = Integer.parseInt(currentLine);
                animation = loadAnimation(numberOfFrames);
            }
            reader.close();
            return animation;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    private String[][] loadAnimation(int numberOfFrames) {
        String[][] Animation = new String[numberOfFrames][];
        for (int frame = 0; frame < numberOfFrames; frame++) {
            int numberOfLines = Integer.parseInt(getLine());
            Animation[frame] = loadFrame(numberOfLines);
        }
        return Animation;
    }

    private String[] loadFrame(int numberOfLines) {
        String[] frame = new String[numberOfLines];
        for (int currentLine = 0; currentLine < numberOfLines; currentLine++) {
            frame[currentLine] = getLine();
        }
         return frame;
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
