package com.epam.factory;

import com.epam.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class PointFactoryTest {

    @Test
    public void createPointTest() {
        Point point = PointFactory.createPoint(1, 2, 3);
        Assert.assertEquals(point.getClass(), Point.class);
    }
}
