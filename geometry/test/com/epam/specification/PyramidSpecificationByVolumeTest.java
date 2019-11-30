package com.epam.specification;

import com.epam.entity.Point;
import com.epam.entity.PyramidIdentifier;
import com.epam.util.PyramidUtil;
import org.junit.Assert;
import org.junit.Test;

public class PyramidSpecificationByVolumeTest {
    private PyramidSpecificationByVolume specification = new PyramidSpecificationByVolume(0,65);

    @Test
    public void testSpecifiedWhenVolumeNotLiesBetweenMinAndMaxValuesReturnFalse(){
        PyramidUtil pyramidUtil = new PyramidUtil();

        //given
        Point a = new Point(2, 4, -1);
        Point b = new Point(6, 4, -1);
        Point c = new Point(6, 8, -1);
        Point d = new Point(2, 8, -1);
        Point o = new Point(4, 6, 12);
        PyramidIdentifier pyramid = new PyramidIdentifier(a, b, c, d, o, 101);
        //when
        boolean actualResultOfSpecification = specification.specified(pyramid);
        //then
        Assert.assertFalse(actualResultOfSpecification);
    }

    @Test
    public void testSpecifiedWhenVolumeLiesBetweenMinAndMaxValuesReturnTrue(){
        //given
        Point a = new Point(2, 4, -1);
        Point b = new Point(6, 4, -1);
        Point c = new Point(6, 8, -1);
        Point d = new Point(2, 8, -1);
        Point o = new Point(4, 6, 5);
        PyramidIdentifier pyramid = new PyramidIdentifier(a, b, c, d, o, 101);
        //when
        boolean actualResultOfSpecification = specification.specified(pyramid);
        //then
        Assert.assertTrue(actualResultOfSpecification);
    }
}
