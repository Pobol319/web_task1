package com.epam.observer;

import com.epam.observer.Impl.PyramidObservableImpl;

public interface Observer {
    void update(PyramidObservableImpl observable);
}
