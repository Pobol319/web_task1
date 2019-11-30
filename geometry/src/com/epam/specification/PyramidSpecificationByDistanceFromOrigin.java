package com.epam.specification;

import com.epam.entity.Point;
import com.epam.entity.PyramidIdentifier;
import com.epam.repository.PyramidSpecification;
import com.epam.util.PyramidUtil;

public class PyramidSpecificationByDistanceFromOrigin implements PyramidSpecification {
    private double allowableDistanceFromOrigin;
    private Point origin = new Point(0, 0, 0);

    PyramidSpecificationByDistanceFromOrigin(double allowableDistanceFromOrigin) {
        this.allowableDistanceFromOrigin = allowableDistanceFromOrigin;
    }

    @Override
    public boolean specified(PyramidIdentifier pyramidIdentifier) {
        PyramidUtil pyramidUtil = new PyramidUtil();
        double distanceFromPointAToOrigin = pyramidUtil.countDistanceBetweenPoints(pyramidIdentifier.getBaseA(), origin);
        double distanceFromPointBToOrigin = pyramidUtil.countDistanceBetweenPoints(pyramidIdentifier.getBaseB(), origin);
        double distanceFromPointCToOrigin = pyramidUtil.countDistanceBetweenPoints(pyramidIdentifier.getBaseC(), origin);
        double distanceFromPointDToOrigin = pyramidUtil.countDistanceBetweenPoints(pyramidIdentifier.getBaseD(), origin);
        double distanceFromPointOToOrigin = pyramidUtil.countDistanceBetweenPoints(pyramidIdentifier.getVertexO(), origin);

        return distanceFromPointAToOrigin < allowableDistanceFromOrigin & distanceFromPointBToOrigin < allowableDistanceFromOrigin &
                distanceFromPointCToOrigin < allowableDistanceFromOrigin & distanceFromPointDToOrigin < allowableDistanceFromOrigin &
                distanceFromPointOToOrigin < allowableDistanceFromOrigin;
    }
}
