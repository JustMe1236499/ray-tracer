package raytracer;

public class Camera {
    Vector3 position;
    Vector3 forward;
    public static int height = 300;
    public static int width = 400;
    public double aspectRatio = (double) width/height;

    public Camera(Vector3 position, Vector3 forward) {
        this.position = position;
        this.forward = forward;
    }

    public Ray getRay(int x, int y) {
        double viewportX = ((x-width/2.0)/(width/2.0))*aspectRatio;
        double viewportY = -(y-height/2.0)/(height/2.0);
        Vector3 viewportPoint = new Vector3(viewportX, viewportY, -1);
        Vector3 rayOrigin = position;
        Vector3 rayDirection = viewportPoint.subtract(position).normalize();
        return new Ray(rayOrigin, rayDirection);
    }
}
