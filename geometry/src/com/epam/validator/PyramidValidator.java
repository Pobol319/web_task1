package com.epam.validator;

import com.epam.entity.Pyramid;
import com.epam.util.PyramidUtil;

public class PyramidValidator {

    public boolean isValidPyramid(Pyramid pyramid) {
        if (!(pyramid.getBaseA().getZ() == pyramid.getBaseB().getZ()
                && pyramid.getBaseC().getZ() == pyramid.getBaseD().getZ()
                && pyramid.getBaseD().getZ() == pyramid.getBaseA().getZ())) {
            return false;
        }

        PyramidUtil pyramidUtil = new PyramidUtil();
        double oA = pyramidUtil.distanceBetweenPoints(pyramid.getVertexO(), pyramid.getBaseA());
        double oB = pyramidUtil.distanceBetweenPoints(pyramid.getVertexO(), pyramid.getBaseB());
        double oC = pyramidUtil.distanceBetweenPoints(pyramid.getVertexO(), pyramid.getBaseC());
        double oD = pyramidUtil.distanceBetweenPoints(pyramid.getVertexO(), pyramid.getBaseD());

        return oA == oB && oC == oD && oD == oA;
    }

}
