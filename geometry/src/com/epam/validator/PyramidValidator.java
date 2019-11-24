package com.epam.validator;

import com.epam.entity.Point;
import com.epam.util.PyramidUtil;

public class PyramidValidator {
    private PyramidUtil pyramidUtil = new PyramidUtil();

    public boolean isPyramid(Point a, Point b, Point c, Point d, Point o) {
        if (!(doesAllPointsLiesOnSameZ(a, b, c, d))) {
            return false;
        }
        if (!(isPointsOfBaseDifferent(a, b, c, d))) {
            return false;
        }
        return isDistanceBetweenVertexAndOtherPointsSame(a, b, c, d, o);
    }

    private boolean doesAllPointsLiesOnSameZ(Point a, Point b, Point c, Point d) {
        return a.getZ() == b.getZ()
                && c.getZ() == d.getZ()
                && d.getZ() == a.getZ();
    }

    private boolean isPointsOfBaseDifferent(Point a, Point b, Point c, Point d) {
        double aB = pyramidUtil.countDistanceBetweenPoints(a, b);
        double bC = pyramidUtil.countDistanceBetweenPoints(b, c);
        double cD = pyramidUtil.countDistanceBetweenPoints(c, d);
        double dA = pyramidUtil.countDistanceBetweenPoints(d, a);
        double aC = pyramidUtil.countDistanceBetweenPoints(a, c);
        double bD = pyramidUtil.countDistanceBetweenPoints(b, d);

        return (aB == cD && bC == dA && aB == bC) && (aC == bD);
    }

    private boolean isDistanceBetweenVertexAndOtherPointsSame(Point a, Point b, Point c, Point d, Point o) {
        double oA = pyramidUtil.countDistanceBetweenPoints(o, a);
        double oB = pyramidUtil.countDistanceBetweenPoints(o, b);
        double oC = pyramidUtil.countDistanceBetweenPoints(o, c);
        double oD = pyramidUtil.countDistanceBetweenPoints(o, d);

        return oA == oB && oC == oD && oD == oA;
    }

}
