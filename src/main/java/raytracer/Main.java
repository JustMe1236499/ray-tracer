package raytracer;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Main {
    public static void main (String[] args){

        final int IMG_WIDTH = 400;
        final int IMG_HEIGHT = 300;
        final int MAX_VAL = 255;
        try (PrintWriter write = new PrintWriter("test.ppm")) {
            write.println("P3");
            write.println(IMG_WIDTH);
            write.println(IMG_HEIGHT);
            write.println(MAX_VAL);
            for (int i = 0; i < IMG_HEIGHT; i++) {
                for (int j = 0; j < IMG_WIDTH; j++) {
                    int r = (int) ((j / (IMG_WIDTH-1.0)) * MAX_VAL);
                    int g = (int) ((i / (IMG_HEIGHT-1.0)) * MAX_VAL);
                    int b = 0;
                    write.println(r + " " + g + " " + b);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file: " + e.getMessage());
        }
    }
}
