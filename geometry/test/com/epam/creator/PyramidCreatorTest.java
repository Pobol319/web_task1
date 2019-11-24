package com.epam.creator;

import com.epam.entity.Point;
import com.epam.validator.PyramidValidator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class PyramidCreatorTest {
    private PyramidValidator pyramidValidator = new PyramidValidator();
    private PyramidCreator pyramidCreator = new PyramidCreator(pyramidValidator);

    @Test
    public void testCreatePyramidWithValidPoints(){
        //given
        Point a = new Point(2, 4, -3);
        Point b = new Point(6, 4, -3);
        Point c = new Point(6, 8, -3);
        Point d = new Point(2, 8, -3);
        Point o = new Point(4, 6, 4);
        Point[] pointsForPositiveTest = new Point[]{a, b, c, d, o};
        // when
        Optional optionalPyramid = pyramidCreator.createPyramid(pointsForPositiveTest);
        //then
        Assert.assertTrue(optionalPyramid.isPresent());
    }

    @Test
    public void testCreatePyramidWithInvalidPoints(){
        //given
        Point a = new Point(2, 4, -3);
        Point b = new Point(6, 4, -1);
        Point c = new Point(6, 8, -3);
        Point d = new Point(2, 8, -3);
        Point o = new Point(4, 6, 4);
        Point[] pointsForNegativeTest = new Point[]{a, b, c, d, o};
        //when
        Optional optionalPyramid = pyramidCreator.createPyramid(pointsForNegativeTest);
        //then
        Assert.assertFalse(optionalPyramid.isPresent());
    }

}
