package com.epam.observer;

import com.epam.entity.Pyramid;

public interface PyramidListener {
    void update(long identifier, Pyramid pyramid);
}
