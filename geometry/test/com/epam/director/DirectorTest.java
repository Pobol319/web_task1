package com.epam.director;

import com.epam.entity.Point;
import com.epam.entity.Pyramid;
import com.epam.exception.DataReaderException;
import org.junit.Assert;
import org.junit.Test;


import java.util.List;

public class DirectorTest {

    @Test
    public void testRunReturnListOfPyramid() throws DataReaderException {
        //given
        Point a = new Point(2, 4, -3);
        Point b = new Point(6, 4, -3);
        Point c = new Point(6, 8, -3);
        Point d = new Point(2, 8, -3);
        Point o = new Point(4, 6, 4);
        Pyramid pyramid = new Pyramid(a, b, c, d, o);
        Director director = new Director();
        //when
        List<Pyramid> listOfPyramids = director.run();
        //then
        Assert.assertEquals(pyramid, listOfPyramids.get(0));
    }
}
