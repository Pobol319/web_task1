package com.epam.util;

import com.epam.entity.Point;
import com.epam.entity.Pyramid;

public class PyramidUtil {

    public double countDistanceBetweenPoints(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) +
                Math.pow(a.getY() - b.getY(), 2) +
                Math.pow(a.getZ() - b.getZ(), 2));
    }

    public double countPyramidSurfaceArea(Pyramid pyramid) {
        double edge = countDistanceBetweenPoints(pyramid.getVertexO(), pyramid.getBaseA());
        double sideOfBase = countDistanceBetweenPoints(pyramid.getBaseA(), pyramid.getBaseB());
        double halfPerimeter = (2 * edge + sideOfBase) / 2;
        double areaOfSideOfPyramid = Math.sqrt(halfPerimeter * (halfPerimeter - edge) * (halfPerimeter - edge) * (halfPerimeter - sideOfBase));
        return 4 * areaOfSideOfPyramid + edge * edge;
    }

    public double countPyramidVolume(Pyramid pyramid) {
        double height = countDistanceBetweenPoints(pyramid.getVertexO(), getCenterOfBase(pyramid));
        double sideOfBase = countDistanceBetweenPoints(pyramid.getBaseA(), pyramid.getBaseB());
        return 1.00 / 3.00 * height * sideOfBase * sideOfBase;
    }

    public boolean doesBaseLiesOnOz(Pyramid pyramid) {
        return pyramid.getBaseA().getZ() == 0 &&
                pyramid.getBaseB().getZ() == 0 &&
                pyramid.getBaseC().getZ() == 0 &&
                pyramid.getBaseD().getZ() == 0;
    }

    public double countRatioOfVolumeOfPyramids(Pyramid pyramid) {
        if (!(isOzAcrossPyramid(pyramid))) {
            return 0;
        }
        Point centerOfSmallPyramidBase = new Point(pyramid.getVertexO().getX(), pyramid.getVertexO().getY(), 0);
        double smallPyramidHeight = countDistanceBetweenPoints(pyramid.getVertexO(), centerOfSmallPyramidBase);
        double bigPyramidHeight = countDistanceBetweenPoints(pyramid.getVertexO(), getCenterOfBase(pyramid));
        double similarityCoefficient = bigPyramidHeight / smallPyramidHeight;
        return Math.pow(similarityCoefficient, 3);
    }

    private Point getCenterOfBase(Pyramid pyramid) {
        return new Point(pyramid.getVertexO().getX(), pyramid.getVertexO().getY(), pyramid.getBaseA().getZ());
    }

    private boolean isOzAcrossPyramid(Pyramid pyramid) {
        return (pyramid.getBaseA().getZ() < 0 & pyramid.getVertexO().getZ() > 0) |
                (pyramid.getBaseA().getZ() > 0 & pyramid.getVertexO().getZ() < 0);
    }


}
