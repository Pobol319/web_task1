package com.epam.observer.impl;

import com.epam.entity.Point;
import com.epam.observer.Impl.PyramidObservableImpl;
import com.epam.observer.Impl.PyramidObserverImpl;
import com.epam.util.PyramidUtil;
import org.junit.Assert;
import org.junit.Test;

public class PyramidObserverImplTest {

    @Test
    public void testUpdateWhenMapIsEmptyReturnMapWithNewValues() {
        //given
        Point a = new Point(2, 4, -1);
        Point b = new Point(6, 4, -1);
        Point c = new Point(6, 8, -1);
        Point d = new Point(2, 8, -1);
        Point o = new Point(4, 6, 12);
        PyramidObservableImpl observable = new PyramidObservableImpl(a, b, c, d, o, 101);

        double ratioOfVolumeOfPyramids = 1.25;
        double pyramidVolume = 69.3;
        double pyramidSurfaceArea = 282.2;

        PyramidObserverImpl observer = PyramidObserverImpl.getInstance();
        //when
        observer.update(observable);
        //then
        Assert.assertEquals(ratioOfVolumeOfPyramids, observer.getPyramidParametersMap().get(observable.getIdentifier()).getRatioOfVolumeOfPyramids(), 1);
        Assert.assertEquals(pyramidVolume, observer.getPyramidParametersMap().get(observable.getIdentifier()).getPyramidVolume(), 1);
        Assert.assertEquals(pyramidSurfaceArea, observer.getPyramidParametersMap().get(observable.getIdentifier()).getPyramidSurfaceArea(), 1);
    }

    @Test
    public void testUpdateWhenMapIsNotEmptyReturnMapWithUpdateValues() {
        //given
        Point a = new Point(2, 4, -1);
        Point b = new Point(6, 4, -1);
        Point c = new Point(6, 8, -1);
        Point d = new Point(2, 8, -1);
        Point o1 = new Point(4, 6, 12);
        PyramidObservableImpl observable = new PyramidObservableImpl(a, b, c, d, o1, 101);
        PyramidObserverImpl observer = PyramidObserverImpl.getInstance();
        observer.update(observable);

        Point o2 = new Point(4, 6, 5);
        observable.setVertexO(o2);

        double ratioOfVolumeOfPyramids = 1.25;
        double pyramidVolume = 32;
        double pyramidSurfaceArea = 94;
        //when
        observer.update(observable);
        //then
        Assert.assertEquals(ratioOfVolumeOfPyramids, observer.getPyramidParametersMap().get(observable.getIdentifier()).getRatioOfVolumeOfPyramids(), 1);
        Assert.assertEquals(pyramidVolume, observer.getPyramidParametersMap().get(observable.getIdentifier()).getPyramidVolume(), 1);
        Assert.assertEquals(pyramidSurfaceArea, observer.getPyramidParametersMap().get(observable.getIdentifier()).getPyramidSurfaceArea(), 1);
    }

}
