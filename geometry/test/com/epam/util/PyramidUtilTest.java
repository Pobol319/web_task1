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
        Point a = new Point();
        a.setX(3);
        a.setY(2);
        a.setZ(1);
        pyramid.setBaseA(a);

        Point b = new Point();
        b.setX(9);
        b.setY(2);
        b.setZ(1);
        pyramid.setBaseB(b);

        Point c = new Point();
        c.setX(9);
        c.setY(8);
        c.setZ(1);
        pyramid.setBaseC(c);

        Point d = new Point();
        d.setX(3);
        d.setY(8);
        d.setZ(1);
        pyramid.setBaseD(d);

        Point o = new Point();
        o.setX(6);
        o.setY(6);
        o.setZ(13);
        pyramid.setVertexO(o);
    }

    @Test
    public void distanceBetweenPointsTest() {
        Assert.assertEquals(6,pyramidUtil.distanceBetweenPoints(pyramid.getBaseA(),pyramid.getBaseB()),0.1);
    }

    @Test
    public void countPyramidSurfaceAreaTest(){
       Assert.assertEquals(320, pyramidUtil.countPyramidSurfaceArea(pyramid),1);
    }

    @Test
    public void countPyramidVolumeTest(){
        Assert.assertEquals(144,pyramidUtil.countPyramidVolume(pyramid),1);
    }

    @Test
    public void doesBaseLiesOnOzTest(){
        Assert.assertFalse(pyramidUtil.doesBaseLiesOnOz(pyramid));
    }

    @Test
    public void ratioOfVolumeOfPyramidsTest(){
        Assert.assertEquals(0,pyramidUtil.ratioOfVolumeOfPyramids(pyramid), 1);
    }

}
