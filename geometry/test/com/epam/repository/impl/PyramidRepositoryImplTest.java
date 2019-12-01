package com.epam.repository.impl;

import com.epam.comparator.IdComparator;
import com.epam.entity.Point;
import com.epam.entity.PyramidIdentifier;
import com.epam.repository.impl.PyramidRepositoryImpl;
import com.epam.specification.PyramidSpecificationById;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PyramidRepositoryImplTest {

    @Test
    public void testSortReturnSortedList() {
        //given
        Point a = new Point(2, 4, -1);
        Point b = new Point(6, 4, -1);
        Point c = new Point(6, 8, -1);
        Point d = new Point(2, 8, -1);
        Point o1 = new Point(4, 6, 12);
        PyramidIdentifier pyramid1 = new PyramidIdentifier(a, b, c, d, o1, 199);

        Point o2 = new Point(5, 7, 13);
        PyramidIdentifier pyramid2 = new PyramidIdentifier(a, b, c, d, o2, 102);

        Point o3 = new Point(6, 8, 14);
        PyramidIdentifier pyramid3 = new PyramidIdentifier(a, b, c, d, o3, 200);

        List<PyramidIdentifier> list = new ArrayList<>();
        list.add(pyramid1);
        list.add(pyramid2);
        list.add(pyramid3);
        PyramidRepositoryImpl pyramidRepositoryImpl = new PyramidRepositoryImpl();
        IdComparator idComparator = new IdComparator();
        //when
        pyramidRepositoryImpl.sort(list,idComparator);
        //then
        Assert.assertEquals(list.get(0),pyramid2);
        Assert.assertEquals(list.get(1),pyramid1);
        Assert.assertEquals(list.get(2),pyramid3);
    }

    @Test
    public void testQueryReturnListWithValuesThatSatisfyingSpecification() {
        //given
        Point a = new Point(2, 4, -1);
        Point b = new Point(6, 4, -1);
        Point c = new Point(6, 8, -1);
        Point d = new Point(2, 8, -1);
        Point o1 = new Point(4, 6, 12);
        PyramidIdentifier pyramid1 = new PyramidIdentifier(a, b, c, d, o1, 199);

        Point o2 = new Point(5, 7, 13);
        PyramidIdentifier pyramid2 = new PyramidIdentifier(a, b, c, d, o2, 102);

        Point o3 = new Point(6, 8, 14);
        PyramidIdentifier pyramid3 = new PyramidIdentifier(a, b, c, d, o3, 200);

        PyramidRepositoryImpl pyramidRepositoryImpl = new PyramidRepositoryImpl();
        pyramidRepositoryImpl.addPyramid(pyramid1);
        pyramidRepositoryImpl.addPyramid(pyramid2);
        pyramidRepositoryImpl.addPyramid(pyramid3);

        PyramidSpecificationById specification = new PyramidSpecificationById(200);
        //when
        List<PyramidIdentifier> list = pyramidRepositoryImpl.query(specification);
        //then
        Assert.assertEquals(list.get(0),pyramid3);
    }
}
