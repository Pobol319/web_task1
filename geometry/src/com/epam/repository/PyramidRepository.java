package com.epam.repository;

import com.epam.entity.PyramidIdentifier;

import java.util.List;

public interface PyramidRepository {

    void addPyramid(PyramidIdentifier pyramidIdentifier);

    void removePyramid(PyramidIdentifier pyramidIdentifier);

    void updatePyramid(PyramidIdentifier pyramidIdentifier);

    List query(PyramidSpecification pyramidSpecification);
}
