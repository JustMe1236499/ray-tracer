package raytracer;

public class Sphere {
    public double radius;
    public Vector3 center;
    public Color sphereColor;

    public Sphere (double radius, Vector3 center, Color color) {
        this.radius = radius;
        this.center = center;
        this.sphereColor = color;
    }

    public double checkHit(Ray ray) {
        //calculate discriminant of ray-sphere intersection quadratic equation
        double a = ray.direction.dot(ray.direction);
        double b = (ray.direction.scalarMult(2).dot(ray.origin.subtract(center)));
        double c = Math.pow(ray.origin.subtract(center).magnitude(), 2)-Math.pow(radius, 2);
        double D = (b*b)-(4*a*c);

        if(D>=0) {
            double t1 = (- b + Math.sqrt(D))/(2*a);
            double t2 = (- b - Math.sqrt(D))/(2*a);
             if (t1<t2) {
                 return t1;
             }
             else {
                 return t2;
             }
        }

        else {
            return -1;
        }
    }
}
