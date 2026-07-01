package raytracer;

public class Ray {
    Vector3 direction;
    Vector3 origin;

    public Ray(Vector3 origin, Vector3 direction) {
        this.origin = origin;
        this.direction = direction;
    }

    //returns the point to which a ray points
    public Vector3 pointAt(double t) {
        return origin.add(direction.scalarMult(t));
    }
}
