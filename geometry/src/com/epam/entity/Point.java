package com.epam.entity;

import java.util.Objects;

public class Point {
    private double x;
    private double y;
    private double z;

    public Point() {
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
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
        Point point = (Point) obj;
        return this.x == point.x && this.y == point.y && this.z == point.z;
    }

    @Override
    public int hashCode() {
        return 17 * Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ";" + z + ")";
    }
}
