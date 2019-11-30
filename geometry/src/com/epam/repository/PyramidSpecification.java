package com.epam.repository;

import com.epam.entity.PyramidIdentifier;

public interface PyramidSpecification {
    boolean specified(PyramidIdentifier pyramidIdentifier);
}
