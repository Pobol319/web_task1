package com.epam.observer;




import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PyramidObserver extends PyramidIdentifier {
    Map<PyramidIdentifier, List<PyramidListener>> listeners = new HashMap<>();

    public PyramidObserver(PyramidIdentifier...identifiers){
        for(PyramidIdentifier identifier : identifiers){
            this.listeners.put(identifier,new ArrayList<>());
        }
    }

    public void addObservable(PyramidIdentifier identifier, PyramidListener listener){
        List<PyramidListener> users = listeners.get(identifier);
        users.add(listener);
    }

    public void removeObservable(PyramidIdentifier identifier, PyramidListener listener){
        List<PyramidListener> users = listeners.get(identifier);
        users.remove(listener);
    }

  /*  public void notify(PyramidIdentifier pyramidIdentifier, )*/


}
