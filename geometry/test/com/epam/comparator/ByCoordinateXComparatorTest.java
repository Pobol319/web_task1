package com.epam.comparator;

import com.epam.entity.Point;
import com.epam.entity.PyramidObservable;
import org.junit.Assert;
import org.junit.Test;

public class ByCoordinateXComparatorTest {
    private ByCoordinateXComparator byCoordinateXComparator = new ByCoordinateXComparator();

    @Test
    public void testCompareReturnPositiveNumber() {
        //given
        Point a = new Point(2, 4, -3);
        Point b = new Point(6, 4, -3);
        Point c = new Point(6, 8, -3);
        Point d = new Point(2, 8, -3);
        Point o1 = new Point(4, 6, 4);
        PyramidObservable pyramid1 = new PyramidObservable(a, b, c, d, o1, 101);

        Point o2 = new Point(3, 6, 4);
        PyramidObservable pyramid2 = new PyramidObservable(a, b, c, d, o2, 102);
        //when
        int actualResultOfCompare = byCoordinateXComparator.compare(pyramid1, pyramid2);
        //then
        Assert.assertTrue(actualResultOfCompare > 0);
    }

    @Test
    public void testCompareReturnNegativeNumber() {
        //given
        Point a = new Point(2, 4, -3);
        Point b = new Point(6, 4, -3);
        Point c = new Point(6, 8, -3);
        Point d = new Point(2, 8, -3);
        Point o1 = new Point(4, 6, 4);
        PyramidObservable pyramid1 = new PyramidObservable(a, b, c, d, o1, 101);

        Point o2 = new Point(3, 6, 4);
        PyramidObservable pyramid2 = new PyramidObservable(a, b, c, d, o2, 102);
        //when
        int actualResultOfCompare = byCoordinateXComparator.compare(pyramid2, pyramid1);
        //then
        Assert.assertTrue(actualResultOfCompare < 0);
    }

    @Test
    public void testCompareReturnZero() {
        //given
        Point a = new Point(2, 4, -3);
        Point b = new Point(6, 4, -3);
        Point c = new Point(6, 8, -3);
        Point d = new Point(2, 8, -3);
        Point o1 = new Point(4, 6, 4);
        PyramidObservable pyramid1 = new PyramidObservable(a, b, c, d, o1, 101);

        Point o2 = new Point(4, 6, 4);
        PyramidObservable pyramid2 = new PyramidObservable(a, b, c, d, o2, 102);
        //when
        int actualResultOfCompare = byCoordinateXComparator.compare(pyramid1, pyramid2);
        //then
        Assert.assertEquals(0, actualResultOfCompare);
    }
}
