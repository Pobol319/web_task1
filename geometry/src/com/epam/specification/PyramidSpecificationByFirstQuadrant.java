package com.epam.specification;

import com.epam.entity.Point;
import com.epam.entity.PyramidIdentifier;
import com.epam.repository.PyramidSpecification;



public class PyramidSpecificationByFirstQuadrant implements PyramidSpecification {

    @Override
    public boolean specified(PyramidIdentifier pyramidIdentifier) {
        boolean pointA = isPointLiesInFirstQuadrant(pyramidIdentifier.getBaseA());
        boolean pointB = isPointLiesInFirstQuadrant(pyramidIdentifier.getBaseB());
        boolean pointC = isPointLiesInFirstQuadrant(pyramidIdentifier.getBaseC());
        boolean pointD = isPointLiesInFirstQuadrant(pyramidIdentifier.getBaseD());
        return pointA & pointB & pointC & pointD;
    }

    private boolean isPointLiesInFirstQuadrant(Point point) {
        boolean pointX = isNumberLiesBetweenZeroAndInfinity(point.getX());
        boolean pointY = isNumberLiesBetweenZeroAndInfinity(point.getY());
        boolean pointZ = isNumberLiesBetweenZeroAndInfinity(point.getZ());
        return pointX & pointY & pointZ;
    }

    private boolean isNumberLiesBetweenZeroAndInfinity(double number) {
        double inf = Double.POSITIVE_INFINITY;
        return number > 0 & number < inf;
    }
}
