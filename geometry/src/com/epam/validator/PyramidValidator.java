package com.epam.validator;

import com.epam.entity.Pyramid;
import com.epam.util.PyramidUtil;

public class PyramidValidator {
    private PyramidUtil pyramidUtil = new PyramidUtil();

    public boolean isPyramid(Pyramid pyramid) {
        if (!(doesAllPointsLiesOnSameZ(pyramid))) {
            return false;
        }
        if(!(isPointsOfBaseDifferent(pyramid))){
            return false;
        }
        if(!(isDistanceBetweenVertexAndOtherPointsSame(pyramid))){
            return false;
        }
        return true;
    }

    private boolean doesAllPointsLiesOnSameZ(Pyramid pyramid) {
        return pyramid.getBaseA().getZ() == pyramid.getBaseB().getZ()
                && pyramid.getBaseC().getZ() == pyramid.getBaseD().getZ()
                && pyramid.getBaseD().getZ() == pyramid.getBaseA().getZ();
    }

    private boolean isPointsOfBaseDifferent(Pyramid pyramid) {
        double aB = pyramidUtil.distanceBetweenPoints(pyramid.getBaseA(), pyramid.getBaseB());
        double bC = pyramidUtil.distanceBetweenPoints(pyramid.getBaseB(), pyramid.getBaseC());
        double cD = pyramidUtil.distanceBetweenPoints(pyramid.getBaseC(), pyramid.getBaseD());
        double dA = pyramidUtil.distanceBetweenPoints(pyramid.getBaseD(), pyramid.getBaseA());
        double aC = pyramidUtil.distanceBetweenPoints(pyramid.getBaseA(), pyramid.getBaseC());
        double bD = pyramidUtil.distanceBetweenPoints(pyramid.getBaseB(), pyramid.getBaseD());

        return (aB==bC && cD==dA && aB == cD) && (aC == bD);
    }

    private boolean isDistanceBetweenVertexAndOtherPointsSame(Pyramid pyramid){
        double oA = pyramidUtil.distanceBetweenPoints(pyramid.getVertexO(), pyramid.getBaseA());
        double oB = pyramidUtil.distanceBetweenPoints(pyramid.getVertexO(), pyramid.getBaseB());
        double oC = pyramidUtil.distanceBetweenPoints(pyramid.getVertexO(), pyramid.getBaseC());
        double oD = pyramidUtil.distanceBetweenPoints(pyramid.getVertexO(), pyramid.getBaseD());

        return oA == oB && oC == oD && oD == oA;
    }

}
