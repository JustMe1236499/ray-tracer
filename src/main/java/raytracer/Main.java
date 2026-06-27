package raytracer;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Main {
    public static void main (String[] args) throws FileNotFoundException {
        PrintWriter write = new PrintWriter("test.ppm");
        write.println("P3 400 300 255");
        for(int i=0; i<300; i++) {
            for(int j=0; j<400; j++) {
                int r = (int)((j/399.0) * 255);
                int g = (int)((i/299.0) *255);
                int b = 0;
                write.println(r + " " + g + " " + b);
            }
        }
        write.close();
    }
}
