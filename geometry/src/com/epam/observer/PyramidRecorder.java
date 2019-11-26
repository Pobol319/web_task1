package com.epam.observer;

import java.util.Observable;

public class PyramidRecorder extends Observable {
    private double surfaceArea;
    private double volume;
    private double ratioOfVolumeOfPyramids;
    private boolean baseLiesOnOz;

    public void changeData(double surfaceArea, double volume, double ratioOfVolumeOfPyramids, boolean baseLiesOnOz){
        this.surfaceArea = surfaceArea;
        this.volume = volume;
        this.ratioOfVolumeOfPyramids = ratioOfVolumeOfPyramids;
        this.baseLiesOnOz = baseLiesOnOz;
    }



}
