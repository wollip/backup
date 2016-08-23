package Projection;

//import static com.ivon.perspectiveprojetion.graphics.Constants.*;

/**
 * Created by Owner on 2/27/2016.
 */
public class Cube {

    private Vector[] vertices;

    public Vector[] getVertices() {
        return vertices;
    }

    public Cube(Vector v, double side) {
        double x0 = v.get(0);
        double y0 = v.get(1);
        double z0 = v.get(2);
        vertices = new Vector[] {
                new Vector(x0, y0, z0),
                new Vector(x0+side, y0, z0),
                new Vector(x0+side, y0, z0+side),
                new Vector(x0, y0, z0+side),
                new Vector(x0, y0+side, z0),
                new Vector(x0+side, y0+side, z0),
                new Vector(x0+side, y0+side, z0+side),
                new Vector(x0, y0+side, z0+side)
        };
    }

}
