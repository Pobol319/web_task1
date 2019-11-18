package com.epam.util;

import com.epam.entity.Point;
import com.epam.entity.Pyramid;

public class PyramidUtil {

    public double distanceBetweenPoints(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) +
                Math.pow(a.getY() - b.getY(), 2) +
                Math.pow(a.getZ() - b.getZ(), 2));
    }

    public double countPyramidSurfaceArea(Pyramid pyramid) {
        double edge = distanceBetweenPoints(pyramid.getVertexO(), pyramid.getBaseA());
        double sideOfBase = distanceBetweenPoints(pyramid.getBaseA(), pyramid.getBaseB());
        double halfPerimeter = (2 * edge + sideOfBase) / 2;
        double areaOfSideOfPyramid = Math.sqrt(halfPerimeter * (halfPerimeter - edge) * (halfPerimeter - edge) * (halfPerimeter - sideOfBase));
        return 4 * areaOfSideOfPyramid + edge * edge;
    }


}
