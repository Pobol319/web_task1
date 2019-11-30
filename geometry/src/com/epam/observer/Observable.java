package com.epam.observer;


import com.epam.entity.PyramidObserver;

public interface Observable {
    public void attach(PyramidObserver observer);

    public void detach(PyramidObserver observer);

    public void notifyObservers();
}
