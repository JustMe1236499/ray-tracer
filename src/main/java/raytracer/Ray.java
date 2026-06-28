package raytracer;

public class Ray {
    Vector3 direction;
    Vector3 origin;

    public Ray(Vector3 origin, Vector3 direction) {
        this.origin = origin;
        this.direction = direction;
    }
}
