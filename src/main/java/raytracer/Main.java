package raytracer;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Main {

    public static Color rayColor(Ray ray) {
        Sphere s1 = new Sphere(3, new Vector3(0,0, -7), new Color(1, 0, 0));
        if(s1.checkHit(ray)>=0) {
            return s1.sphereColor;
        }
        else {
            double t = (ray.direction.y + 1) / 2;
            return new Color(1 - t, 1 - t, 1);
        }
    }

    public static void main (String[] args){
        Camera camera = new Camera(new Vector3(0,0,0), new Vector3(0,0,-1), new Vector3(1,0,0), new Vector3(0,1,0));

        final int IMG_WIDTH = Camera.width;
        final int IMG_HEIGHT = Camera.height;
        final int MAX_VAL = 255;
        try (PrintWriter write = new PrintWriter("test.ppm")) {
            write.println("P3");
            write.println(IMG_WIDTH);
            write.println(IMG_HEIGHT);
            write.println(MAX_VAL);
            for (int i = 0; i < IMG_HEIGHT; i++) {
                for (int j = 0; j < IMG_WIDTH; j++) {
                    Ray ray = camera.getRay(j,i);
                    Color pixelColor = rayColor(ray);
                    write.println((int)(pixelColor.color.x*255) + " " + (int)(pixelColor.color.y*255) + " " + (int)(pixelColor.color.z*255));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file: " + e.getMessage());
        }
    }
}
