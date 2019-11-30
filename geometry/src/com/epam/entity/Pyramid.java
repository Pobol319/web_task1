package com.epam.entity;

import java.util.Objects;

public class Pyramid {
    private Point baseA;
    private Point baseB;
    private Point baseC;
    private Point baseD;
    private Point vertexO;

    public Pyramid() {
    }

    public Pyramid(Point a, Point b, Point c, Point d, Point o) {
        this.baseA = a;
        this.baseB = b;
        this.baseC = c;
        this.baseD = d;
        this.vertexO = o;
    }

    public void setBaseA(Point baseA) {
        this.baseA = baseA;
    }

    public void setBaseB(Point baseB) {
        this.baseB = baseB;
    }

    public void setBaseC(Point baseC) {
        this.baseC = baseC;
    }

    public void setBaseD(Point baseD) {
        this.baseD = baseD;
    }

    public void setVertexO(Point vertexO) {
        this.vertexO = vertexO;
    }

    public Point getBaseA() {
        return baseA;
    }

    public Point getBaseB() {
        return baseB;
    }

    public Point getBaseC() {
        return baseC;
    }

    public Point getBaseD() {
        return baseD;
    }

    public Point getVertexO() {
        return vertexO;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pyramid pyramidObj = (Pyramid) obj;
        return this.baseA.equals(pyramidObj.baseA) &&
                this.baseB.equals(pyramidObj.baseB) &&
                this.baseC.equals(pyramidObj.baseC) &&
                this.baseD.equals(pyramidObj.baseD) &&
                this.vertexO.equals(pyramidObj.vertexO);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + 13 * this.baseA.hashCode() + 19 * this.baseB.hashCode() +
                23 * this.baseC.hashCode() + 29 * this.baseD.hashCode() + 31 * this.vertexO.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Point A:" + baseA.toString() + " Point B:" + baseB.toString() + " Point C:" + baseC.toString() + " Vertex O:" + vertexO.toString();
    }
}
