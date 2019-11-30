package com.epam.entity;

import com.epam.observer.Observable;
import com.epam.observer.Observer;
import com.epam.util.PyramidUtil;

import java.util.HashMap;
import java.util.Map;

public class PyramidObserver implements Observer {
    private Map<Long, PyramidParameters> map = new HashMap<>();
    private PyramidUtil pyramidUtil;

    private static PyramidObserver instance;

    private PyramidObserver(PyramidUtil pyramidUtil) {
        this.pyramidUtil = pyramidUtil;
    }

    public static PyramidObserver getInstance() {
        if (instance == null) {
            instance = new PyramidObserver(new PyramidUtil());
        }
        return instance;
    }


    @Override
    public void update(PyramidObservable observable) {
        long identifier = observable.getIdentifier();

        if (!map.containsKey(identifier)) {
            PyramidParameters pyramidParameters = new PyramidParameters();
            pyramidParameters.setPyramidSurfaceArea(pyramidUtil.countPyramidSurfaceArea(observable));
            pyramidParameters.setPyramidVolume(pyramidUtil.countPyramidVolume(observable));
            pyramidParameters.setRatioOfVolumeOfPyramids(pyramidUtil.countRatioOfVolumeOfPyramids(observable));
            map.put(identifier, pyramidParameters);
            System.out.println(map.get(identifier).toString());
        } else {
            map.get(identifier).setPyramidSurfaceArea(pyramidUtil.countPyramidSurfaceArea(observable));
            map.get(identifier).setPyramidVolume(pyramidUtil.countPyramidVolume(observable));
            map.get(identifier).setRatioOfVolumeOfPyramids(pyramidUtil.countRatioOfVolumeOfPyramids(observable));
            System.out.println(map.get(identifier).toString());
        }
    }
}
