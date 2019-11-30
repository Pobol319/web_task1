package com.epam.observer;

import com.epam.entity.PyramidObservable;

public interface Observer {
    void update(PyramidObservable observable);
}
