package com.epam.creator;

import com.epam.entity.Point;
import com.epam.entity.Pyramid;
import com.epam.validator.PyramidValidator;

import java.util.Optional;

public class PyramidCreator {
    private PyramidValidator pyramidValidator;

    public PyramidCreator(PyramidValidator pyramidValidator) {
        this.pyramidValidator = pyramidValidator;
    }

    public Optional<Pyramid> createPyramid(Point[] points) {
        if (pyramidValidator.isPyramid(points[0], points[1], points[2], points[3], points[4])) {
            Pyramid pyramid = new Pyramid();
            pyramid.setBaseA(points[0]);
            pyramid.setBaseB(points[1]);
            pyramid.setBaseC(points[2]);
            pyramid.setBaseD(points[3]);
            pyramid.setVertexO(points[4]);
            return Optional.of(pyramid);
        }
        return Optional.empty();
    }
}
