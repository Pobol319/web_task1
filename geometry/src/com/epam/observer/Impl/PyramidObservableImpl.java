package com.epam.observer.Impl;

import com.epam.entity.Point;
import com.epam.entity.PyramidIdentifier;
import com.epam.observer.Observable;

import java.util.ArrayList;
import java.util.List;

public class PyramidObservableImpl extends PyramidIdentifier implements Observable {
    private List<PyramidObserverImpl> observers = new ArrayList<>();

    public PyramidObservableImpl(Point a, Point b, Point c, Point d, Point o, long identifier) {
        super(a, b, c, d, o, identifier);
    }

    public void setBaseA(Point baseA) {
        super.setBaseA(baseA);
        notifyObservers();
    }

    public void setBaseB(Point baseB) {
        super.setBaseB(baseB);
        notifyObservers();
    }

    public void setBaseC(Point baseC) {
        super.setBaseC(baseC);
        notifyObservers();
    }

    public void setBaseD(Point baseD) {
        super.setBaseD(baseD);
        notifyObservers();
    }

    public void setVertexO(Point vertexO) {
        super.setVertexO(vertexO);
        notifyObservers();
    }

    @Override
    public void attach(PyramidObserverImpl observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(PyramidObserverImpl observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (PyramidObserverImpl observer : this.observers) {
            observer.update(this);
        }
    }
}
