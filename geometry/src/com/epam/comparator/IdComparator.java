package com.epam.comparator;

import com.epam.entity.PyramidIdentifier;

import java.util.Comparator;

public class IdComparator implements Comparator<PyramidIdentifier> {

    @Override
    public int compare(PyramidIdentifier o1, PyramidIdentifier o2) {
        return Long.compare(o1.getIdentifier(), o2.getIdentifier());
    }
}
