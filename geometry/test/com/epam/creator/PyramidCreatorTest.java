package com.epam.creator;

import com.epam.entity.Point;
import com.epam.validator.PyramidValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PyramidCreatorTest {
    @Mock
    PyramidValidator pyramidValidator;

    @InjectMocks
    private PyramidCreator pyramidCreator = new PyramidCreator(pyramidValidator);

    @Test
    public void testCreatePyramidWithValidPointsReturnTrue(){
        //given
        Point a = new Point(2, 4, -3);
        Point b = new Point(6, 4, -3);
        Point c = new Point(6, 8, -3);
        Point d = new Point(2, 8, -3);
        Point o = new Point(4, 6, 4);
        Point[] points = new Point[]{a, b, c, d, o};

        when(pyramidValidator.isPyramid(a,b,c,d,o)).thenReturn(true);
        // when
        Optional optionalPyramid = pyramidCreator.createPyramid(points);
        //then
        verify(pyramidValidator).isPyramid(a,b,c,d,o);
        Assert.assertTrue(optionalPyramid.isPresent());
    }

    @Test
    public void testCreatePyramidWithInvalidPointsReturnFalse(){
        //given
        Point a = new Point(2, 4, -3);
        Point b = new Point(6, 4, -1);
        Point c = new Point(6, 8, -3);
        Point d = new Point(2, 8, -3);
        Point o = new Point(4, 6, 4);
        Point[] points = new Point[]{a, b, c, d, o};

        when(pyramidValidator.isPyramid(a,b,c,d,o)).thenReturn(false);
        //when
        Optional optionalPyramid = pyramidCreator.createPyramid(points);
        //then
        verify(pyramidValidator).isPyramid(a,b,c,d,o);
        Assert.assertFalse(optionalPyramid.isPresent());
    }

}
