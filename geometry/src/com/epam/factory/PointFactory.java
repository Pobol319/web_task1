package com.epam.factory;

import com.epam.entity.Point;

public class PointFactory {

    public static Point createPoint(double x, double y, double z) {
        Point point = new Point();
        point.setX(x);
        point.setY(y);
        point.setZ(z);
        return point;
    }

}
