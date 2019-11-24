package com.epam.validator;

import com.epam.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class PyramidValidatorTest {
    private PyramidValidator pyramidValidator = new PyramidValidator();

    @Test
    public void testIsPyramidWherePointsHaveDifferentZ() {
        //given
        Point a = new Point(2, 4, -3);
        Point b = new Point(6, 4, -3);
        Point c = new Point(6, 8, -2);
        Point d = new Point(2, 8, -3);
        Point o = new Point(4, 6, 4);
        //when
        boolean expectedFalse = pyramidValidator.isPyramid(a, b, c, d, o);
        //then
        Assert.assertFalse(expectedFalse);
    }

    @Test
    public void testIsPyramidWherePointsHaveSameCoordinates() {
        //given
        Point a = new Point(2, 4, -3);
        Point b = new Point(2, 4, -3);
        Point c = new Point(6, 8, -3);
        Point d = new Point(2, 8, -3);
        Point o = new Point(4, 6, 4);
        //when
        boolean expectedFalse = pyramidValidator.isPyramid(a, b, c, d, o);
        //then
        Assert.assertFalse(expectedFalse);
    }

    @Test
    public void testIsPyramidWhereDistanceBetweenVertexAndPointsOfBaseDifferent() {
        //given
        Point a = new Point(2, 4, -3);
        Point b = new Point(2, 4, -3);
        Point c = new Point(6, 8, -3);
        Point d = new Point(2, 8, -3);
        Point o = new Point(2, 6, 4);
        //when
        boolean expectedFalse = pyramidValidator.isPyramid(a, b, c, d, o);
        //then
        Assert.assertFalse(expectedFalse);
    }

    @Test
    public void testIsPyramidPositiveScenario() {
        //given
        Point a = new Point(2, 4, -3);
        Point b = new Point(6, 4, -3);
        Point c = new Point(6, 8, -3);
        Point d = new Point(2, 8, -3);
        Point o = new Point(4, 6, 4);
        //when
        boolean expectedTrue = pyramidValidator.isPyramid(a, b, c, d, o);
        //then
        Assert.assertTrue(expectedTrue);
    }
}
