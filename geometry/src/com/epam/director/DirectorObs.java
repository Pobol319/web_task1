package com.epam.director;

import com.epam.entity.Point;
import com.epam.entity.PyramidObservable;
import com.epam.entity.PyramidObserver;

public class DirectorObs {
    public static void main(String[] args) {
        PyramidObserver observer = PyramidObserver.getInstance();

        Point a = new Point(2, 4, -3);
        Point b = new Point(6, 4, -3);
        Point c = new Point(6, 8, -3);
        Point d = new Point(2, 8, -3);
        Point o = new Point(4, 6, 4);

        PyramidObservable pyramid1 = new PyramidObservable(a, b, c, d, o, 101);
        pyramid1.attach(observer);
        Point o2 = new Point(4,6,10);
        pyramid1.setVertexO(o2);
        Point o3 = new Point(4,6,4);
        pyramid1.setVertexO(o3);


    }
}
