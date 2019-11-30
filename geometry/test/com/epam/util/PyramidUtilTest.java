package com.epam.util;

import com.epam.entity.Point;
import com.epam.entity.Pyramid;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PyramidUtilTest {
    private PyramidUtil pyramidUtil = new PyramidUtil();
    private static Pyramid pyramid = new Pyramid();

    @BeforeClass
    public static void setUp() {
        Point a = new Point(3, 2, 1);
        Point b = new Point(9, 2, 1);
        Point c = new Point(9, 8, 1);
        Point d = new Point(3, 8, 1);
        Point o = new Point(6, 6, 13);
        pyramid.setBaseA(a);
        pyramid.setBaseB(b);
        pyramid.setBaseC(c);
        pyramid.setBaseD(d);
        pyramid.setVertexO(o);
    }

    @Test
    public void testCountDistanceBetweenPointsReturnDistanceBetweenPoints() {
        Assert.assertEquals(6, pyramidUtil.countDistanceBetweenPoints(pyramid.getBaseA(), pyramid.getBaseB()), 0.1);
    }

    @Test
    public void testCountPyramidSurfaceAreaReturnSurfaceArea() {
        Assert.assertEquals(320, pyramidUtil.countPyramidSurfaceArea(pyramid), 1);
    }

    @Test
    public void testCountPyramidVolumeReturnVolume() {
        Assert.assertEquals(144, pyramidUtil.countPyramidVolume(pyramid), 1);
    }

    @Test
    public void testDoesBaseLiesOnOzWhenPyramidNotLiesOnOzReturnFalse() {
        Assert.assertFalse(pyramidUtil.doesBaseLiesOnOz(pyramid));
    }

    @Test
    public void testDoesBaseLiesOnOzWhenPyramidLiesOnOzReturnTrue() {
        Pyramid pyramid2 = new Pyramid();
        Point a = new Point(3, 2, 0);
        Point b = new Point(9, 2, 0);
        Point c = new Point(9, 8, 0);
        Point d = new Point(3, 8, 0);
        Point o = new Point(6, 6, 13);
        pyramid2.setBaseA(a);
        pyramid2.setBaseB(b);
        pyramid2.setBaseC(c);
        pyramid2.setBaseD(d);
        pyramid2.setVertexO(o);

        Assert.assertTrue(pyramidUtil.doesBaseLiesOnOz(pyramid2));
    }

    @Test
    public void testCountRatioOfVolumeOfPyramidsWhenOzNotAcrossPyramidReturnZero() {
        Assert.assertEquals(0, pyramidUtil.countRatioOfVolumeOfPyramids(pyramid), 1);
    }

    @Test
    public void testCountRatioOfVolumeOfPyramidsWhenOzAcrossPyramidReturnRatio() {
        Pyramid pyramid2 = new Pyramid();
        Point a = new Point(3, 2, -2);
        Point b = new Point(9, 2, -2);
        Point c = new Point(9, 8, -2);
        Point d = new Point(3, 8, -2);
        Point o = new Point(6, 6, 13);
        pyramid2.setBaseA(a);
        pyramid2.setBaseB(b);
        pyramid2.setBaseC(c);
        pyramid2.setBaseD(d);
        pyramid2.setVertexO(o);

        Assert.assertEquals(1.5, pyramidUtil.countRatioOfVolumeOfPyramids(pyramid2), 1);
    }

}
