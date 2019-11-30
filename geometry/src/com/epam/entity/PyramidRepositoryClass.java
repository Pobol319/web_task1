package com.epam.entity;

import com.epam.repository.PyramidRepository;
import com.epam.repository.PyramidSpecification;

import java.util.*;

public class PyramidRepositoryClass implements PyramidRepository {
    private Map<Long, PyramidIdentifier> pyramidMap = new HashMap<>();

    @Override
    public void addPyramid(PyramidIdentifier pyramidIdentifier) {
        pyramidMap.put(pyramidIdentifier.getIdentifier(), pyramidIdentifier);
    }

    @Override
    public void removePyramid(PyramidIdentifier pyramidIdentifier) {
        pyramidMap.remove(pyramidIdentifier.getIdentifier());
    }

    @Override
    public void updatePyramid(PyramidIdentifier pyramidIdentifier) {
        pyramidMap.replace(pyramidIdentifier.getIdentifier(), pyramidIdentifier);
    }

    @Override
    public List query(PyramidSpecification pyramidSpecification) {
        List<PyramidIdentifier> pyramids = new ArrayList<>();
        Set<Long> keys = pyramidMap.keySet();
        for (Long key : keys) {
            PyramidIdentifier pyramid = pyramidMap.get(key);
            if (pyramidSpecification.specified(pyramid)) {
                pyramids.add(pyramid);
            }
        }
        return pyramids;
    }
}
