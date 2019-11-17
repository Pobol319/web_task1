package com.epam.util;

import com.epam.entity.Point;

public class PyramidUtil {

    public double distanceBetweenPoints(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) +
                Math.pow(a.getY() - b.getY(), 2) +
                Math.pow(a.getZ() - b.getZ(), 2));
    }
}
