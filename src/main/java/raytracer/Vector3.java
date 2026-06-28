package raytracer;

public class Vector3 {
    public double x;
    public double y;
    public double z;


    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 add(Vector3 other) {
        return new Vector3(this.x+other.x, this.y+other.y, this.z+other.z);
    }

    public Vector3 subtract(Vector3 other) {
        return new Vector3(this.x-other.x, this.y-other.y, this.z-other.z);
    }

    public double dot(Vector3 other) {
        return (x*other.x + y*other.y + z*other.z);
    }

    public Vector3 cross(Vector3 other) {
        double xNew = y*other.z - other.y*z;
        double yNew = z * other.x - x * other.z;
        double zNew = x*other.y - other.x*y;

        return new Vector3(xNew, yNew, zNew);
    }

    public double magnitude() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public Vector3 normalize() {
        double mag = this.magnitude();
        if (mag<1e-10) {
            return new Vector3(0,0,0);
        }
        return new Vector3(x/mag, y/mag, z/mag);
    }

    public Vector3 scalarMult(double k) {
        return new Vector3(k*x, k*y, k*z);
    }

    public Vector3 reflect(Vector3 N) {
        double k = 2*this.dot(N);
        Vector3 temp = N.scalarMult(k);
        return this.subtract(temp);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
