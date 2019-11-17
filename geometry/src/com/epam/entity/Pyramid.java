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
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pyramid pyramid = (Pyramid) obj;
        return baseA.equals(pyramid.baseA) &&
                baseB.equals(pyramid.baseB) &&
                baseC.equals(pyramid.baseC) &&
                baseD.equals(pyramid.baseD) &&
                vertexO.equals(pyramid.vertexO);
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(baseA, baseB, baseC, baseD, vertexO);
    }

    @Override
    public String toString() {
        return "Point A:" + baseA.toString() + " Point B:" + baseB.toString() + " Point C:" + baseC.toString() + " Vertex O:" + vertexO.toString();
    }
}
