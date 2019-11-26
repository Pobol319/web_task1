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
    public void testDistanceBetweenPoints() {
        Assert.assertEquals(6, pyramidUtil.countDistanceBetweenPoints(pyramid.getBaseA(), pyramid.getBaseB()), 0.1);
    }

    @Test
    public void testCountPyramidSurfaceArea() {
        Assert.assertEquals(320, pyramidUtil.countPyramidSurfaceArea(pyramid), 1);
    }

    @Test
    public void testCountPyramidVolume() {
        Assert.assertEquals(144, pyramidUtil.countPyramidVolume(pyramid), 1);
    }

    @Test
    public void testDoesBaseLiesOnOz() {
        Assert.assertFalse(pyramidUtil.doesBaseLiesOnOz(pyramid));
    }

    @Test
    public void testCountRatioOfVolumeOfPyramids() {
        Assert.assertEquals(0, pyramidUtil.countRatioOfVolumeOfPyramids(pyramid), 1);
    }

}
