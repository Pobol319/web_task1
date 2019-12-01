package com.epam.comparator;

import com.epam.entity.Point;
import com.epam.entity.PyramidIdentifier;
import org.junit.Assert;
import org.junit.Test;

public class IdComparatorTest {
    private IdComparator idComparator = new IdComparator();

    @Test
    public void testCompareReturnPositiveNumber() {
        //given
        Point a = new Point(2, 4, -3);
        Point b = new Point(6, 4, -3);
        Point c = new Point(6, 8, -3);
        Point d = new Point(2, 8, -3);
        Point o1 = new Point(4, 6, 4);
        PyramidIdentifier pyramid1 = new PyramidIdentifier(a, b, c, d, o1, 102);

        Point o2 = new Point(3, 6, 4);
        PyramidIdentifier pyramid2 = new PyramidIdentifier(a, b, c, d, o2, 101);
        //when
        int actualResultOfCompare = idComparator.compare(pyramid1, pyramid2);
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
        PyramidIdentifier pyramid1 = new PyramidIdentifier(a, b, c, d, o1, 101);

        Point o2 = new Point(3, 6, 4);
        PyramidIdentifier pyramid2 = new PyramidIdentifier(a, b, c, d, o2, 102);
        //when
        int actualResultOfCompare = idComparator.compare(pyramid1, pyramid2);
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
        PyramidIdentifier pyramid1 = new PyramidIdentifier(a, b, c, d, o1, 101);

        Point o2 = new Point(4, 6, 4);
        PyramidIdentifier pyramid2 = new PyramidIdentifier(a, b, c, d, o2, 101);
        //when
        int actualResultOfCompare = idComparator.compare(pyramid1, pyramid2);
        //then
        Assert.assertEquals(0, actualResultOfCompare);
    }
}
