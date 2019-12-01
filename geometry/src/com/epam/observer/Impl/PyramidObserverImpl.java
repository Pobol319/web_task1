package com.epam.observer.Impl;

import com.epam.entity.Pyramid;
import com.epam.entity.PyramidParameters;
import com.epam.observer.Observer;
import com.epam.util.PyramidUtil;

import java.util.HashMap;
import java.util.Map;

public class PyramidObserverImpl implements Observer {
    private Map<Long, PyramidParameters> map = new HashMap<>();
    private PyramidUtil pyramidUtil;

    private static PyramidObserverImpl instance;

    private PyramidObserverImpl(PyramidUtil pyramidUtil) {
        this.pyramidUtil = pyramidUtil;
    }

    public static PyramidObserverImpl getInstance() {
        if (instance == null) {
            instance = new PyramidObserverImpl(new PyramidUtil());
        }
        return instance;
    }

    @Override
    public void update(PyramidObservableImpl observable) {
        long identifier = observable.getIdentifier();

        if (!map.containsKey(identifier)) {
            PyramidParameters pyramidParameters = new PyramidParameters();
            pyramidParameters.setPyramidSurfaceArea(pyramidUtil.countPyramidSurfaceArea(observable));
            pyramidParameters.setPyramidVolume(pyramidUtil.countPyramidVolume(observable));
            pyramidParameters.setRatioOfVolumeOfPyramids(pyramidUtil.countRatioOfVolumeOfPyramids(observable));
            map.put(identifier, pyramidParameters);
        } else {
            map.get(identifier).setPyramidSurfaceArea(pyramidUtil.countPyramidSurfaceArea(observable));
            map.get(identifier).setPyramidVolume(pyramidUtil.countPyramidVolume(observable));
            map.get(identifier).setRatioOfVolumeOfPyramids(pyramidUtil.countRatioOfVolumeOfPyramids(observable));
        }
    }

    public Map<Long, PyramidParameters> getPyramidParametersMap() {
        return map;
    }
}
