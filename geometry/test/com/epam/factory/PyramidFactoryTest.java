package com.epam.factory;

import com.epam.entity.Point;
import com.epam.entity.Pyramid;
import org.junit.Assert;
import org.junit.Test;

public class PyramidFactoryTest {

    @Test
    public void createPyramidTest(){
        Point a = new Point();
        Point b = new Point();
        Point c = new Point();
        Point d = new Point();
        Point o = new Point();
        Point[] points = {a,b,c,d,o};
        Pyramid pyramid = PyramidFactory.createPyramid(points);
        Assert.assertEquals(pyramid.getClass(),Pyramid.class);
    }

}
