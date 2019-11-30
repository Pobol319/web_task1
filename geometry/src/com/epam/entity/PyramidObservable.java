package com.epam.entity;

import com.epam.observer.Observable;

import java.util.ArrayList;
import java.util.List;

public class PyramidObservable extends PyramidIdentifier implements Observable {
    private List<PyramidObserver> observers = new ArrayList<>();

    public PyramidObservable(Point a, Point b, Point c, Point d, Point o, long identifier) {
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
    public void attach(PyramidObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(PyramidObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (PyramidObserver observer : this.observers) {
            observer.update(this);
        }
    }
}
