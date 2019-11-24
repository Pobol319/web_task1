package com.epam.entity;

import java.util.Objects;

public class Point {
    private final double x;
    private final double y;
    private final double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Point pointObj = (Point) obj;
        return this.x == pointObj.x && this.y == pointObj.y && this.z == pointObj.z;
    }

    @Override
    public int hashCode() {
        int result = 17;
        long longBits = Double.doubleToLongBits(x) * Double.doubleToLongBits(y) * Double.doubleToLongBits(z);
        result = 37 * result + (int) (longBits - (longBits >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ";" + z + ")";
    }
}
