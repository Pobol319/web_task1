package com.epam.entity;

public class PyramidParameters {
    private double pyramidSurfaceArea;
    private double pyramidVolume;
    private double ratioOfVolumeOfPyramids;

    public void setPyramidSurfaceArea(double pyramidSurfaceArea) {
        this.pyramidSurfaceArea = pyramidSurfaceArea;
    }

    public void setPyramidVolume(double pyramidVolume) {
        this.pyramidVolume = pyramidVolume;
    }

    public void setRatioOfVolumeOfPyramids(double ratioOfVolumeOfPyramids) {
        this.ratioOfVolumeOfPyramids = ratioOfVolumeOfPyramids;
    }

    public double getPyramidSurfaceArea() {
        return pyramidSurfaceArea;
    }

    public double getPyramidVolume() {
        return pyramidVolume;
    }

    public double getRatioOfVolumeOfPyramids() {
        return ratioOfVolumeOfPyramids;
    }

    public String toString() {
        return "Площадь поверхности = " + pyramidSurfaceArea + "; Объем = " + pyramidVolume + "; Отношение объемов = " + ratioOfVolumeOfPyramids;
    }

}
