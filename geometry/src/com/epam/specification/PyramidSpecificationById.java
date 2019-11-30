package com.epam.specification;

import com.epam.entity.PyramidIdentifier;
import com.epam.repository.PyramidSpecification;

public class PyramidSpecificationById implements PyramidSpecification {
    private long identifier;

    public PyramidSpecificationById(long identifier) {
        super();
        this.identifier = identifier;
    }

    @Override
    public boolean specified(PyramidIdentifier pyramidIdentifier) {
        return identifier == pyramidIdentifier.getIdentifier();
    }
}
