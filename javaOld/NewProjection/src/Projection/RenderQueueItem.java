package Projection;

import java.awt.*;

/**
 * Created by Owner on 2/27/2016.
 */
public class RenderQueueItem {

    public final Polygon polygon;
    public final double depth;

    public RenderQueueItem(double depth, Point... points) {
        int[] xpoints = new int[points.length];
        int[] ypoints = new int[points.length];
        for (int i=0; i<points.length; i++) {
            xpoints[i] = points[i].x;
            ypoints[i] = points[i].y;
        }
        this.polygon = new Polygon(xpoints, ypoints, points.length);
        this.depth = depth;
    }

}
