package com.epam.comparator;

import com.epam.entity.PyramidIdentifier;

import java.util.Comparator;

public class ByCoordinateXComparator implements Comparator<PyramidIdentifier> {
    @Override
    public int compare(PyramidIdentifier o1, PyramidIdentifier o2) {
        return Double.compare(o1.getVertexO().getX(), o2.getVertexO().getX());
    }
}
