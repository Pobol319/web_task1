package com.epam.specification;

import com.epam.entity.PyramidIdentifier;
import com.epam.repository.PyramidSpecification;
import com.epam.util.PyramidUtil;

public class PyramidSpecificationByVolume implements PyramidSpecification {
    private double minVolume;
    private double maxVolume;

    public PyramidSpecificationByVolume(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specified(PyramidIdentifier pyramidIdentifier) {
        PyramidUtil pyramidUtil = new PyramidUtil();
        double volume = pyramidUtil.countPyramidVolume(pyramidIdentifier);
        return minVolume > volume & volume < maxVolume;
    }
}
