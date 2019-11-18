package com.epam.factory;

import com.epam.entity.Point;
import com.epam.entity.Pyramid;

public class PyramidFactory {

    public static Pyramid createPyramid(Point[] points) {
        Pyramid pyramid = new Pyramid();
        pyramid.setBaseA(points[0]);
        pyramid.setBaseB(points[1]);
        pyramid.setBaseC(points[2]);
        pyramid.setBaseD(points[3]);
        pyramid.setVertexO(points[4]);
        return pyramid;
    }

}
