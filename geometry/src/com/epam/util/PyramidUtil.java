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

    public double countPyramidVolume(Pyramid pyramid) {
        double height = distanceBetweenPoints(getCenterOfBase(pyramid), pyramid.getVertexO());
        double sideOfBase = distanceBetweenPoints(pyramid.getBaseA(), pyramid.getBaseB());
        return 1.00 / 3.00 * height * sideOfBase * sideOfBase;
    }

    public boolean doesBaseLiesOnOz(Pyramid pyramid) {
        return pyramid.getBaseA().getZ() == 0 &&
                pyramid.getBaseB().getZ() == 0 &&
                pyramid.getBaseC().getZ() == 0 &&
                pyramid.getBaseC().getZ() == 0;
    }

    public double ratioOfVolumeOfPyramids(Pyramid pyramid) {
        if (!(isOzAcrossPyramid(pyramid))) {
            return 0;
        }
        Point centerOfSmallPyramidBase = pyramid.getVertexO();
        centerOfSmallPyramidBase.setZ(0);
        double smallPyramidHeight = distanceBetweenPoints(pyramid.getVertexO(), centerOfSmallPyramidBase);
        double bigPyramidHeight = distanceBetweenPoints(pyramid.getVertexO(), getCenterOfBase(pyramid));
        double similarityCoefficient = bigPyramidHeight / smallPyramidHeight;
        return Math.pow(similarityCoefficient, 3);
    }

    private Point getCenterOfBase(Pyramid pyramid) {
        Point centerOfBase = pyramid.getVertexO();
        centerOfBase.setZ(pyramid.getBaseA().getZ());
        return centerOfBase;
    }

    private boolean isOzAcrossPyramid(Pyramid pyramid) {
        return (pyramid.getBaseA().getZ() < 0 & pyramid.getVertexO().getZ() > 0) |
                (pyramid.getBaseA().getZ() > 0 & pyramid.getVertexO().getZ() < 0);
    }


}
