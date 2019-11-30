package com.epam.comparator;

import com.epam.entity.PyramidIdentifier;

import java.util.Comparator;

public class ByCoordinateYComparator implements Comparator<PyramidIdentifier> {
    @Override
    public int compare(PyramidIdentifier o1, PyramidIdentifier o2) {
        return Double.compare(o1.getVertexO().getY(), o2.getVertexO().getY());
    }
}
