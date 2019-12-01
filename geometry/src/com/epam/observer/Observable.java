package com.epam.observer;


import com.epam.observer.Impl.PyramidObserverImpl;

public interface Observable {
    public void attach(PyramidObserverImpl observer);

    public void detach(PyramidObserverImpl observer);

    public void notifyObservers();
}
