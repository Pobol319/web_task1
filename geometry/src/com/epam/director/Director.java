package com.epam.director;

import com.epam.converter.ConverterToArray;
import com.epam.entity.Point;
import com.epam.entity.Pyramid;
import com.epam.exception.TxtReaderException;
import com.epam.factory.PointFactory;
import com.epam.factory.PyramidFactory;
import com.epam.reader.TxtReader;
import com.epam.validator.FileDataValidator;
import com.epam.validator.PyramidValidator;

import java.util.ArrayList;
import java.util.List;


public class Director {
    private static final String NUMBERS_PATH = "resources\\numbers.txt";
    private TxtReader txtReader = new TxtReader();
    private ConverterToArray converterToArray = new ConverterToArray();
    private FileDataValidator fileDataValidator = new FileDataValidator();
    private PyramidValidator pyramidValidator = new PyramidValidator();

    public static void main(String[] args) throws TxtReaderException {
        Director director = new Director();
        director.createListOfPyramids();
    }

    public void createListOfPyramids() throws TxtReaderException {
        List<String> listOfRowsFromFile = txtReader.getTextFromFile(NUMBERS_PATH);
        List<double[]> listOfDoubleArrays = getListOfDoubleArrays(listOfRowsFromFile);
        List<Point[]> listOfPointsOfPyramid = getListOfPointsOfPyramid(listOfDoubleArrays);
        List<Pyramid> listOfPyramid = getListOfPyramid(listOfPointsOfPyramid);
    }

    private List<double[]> getListOfDoubleArrays(List<String> listOfRowsFromFile) {
        List<double[]> listOfDoubleArrays = new ArrayList<>();
        for (String temp : listOfRowsFromFile) {
            if (fileDataValidator.isValidRow(temp)) {
                listOfDoubleArrays.add(converterToArray.getDoubleArray(temp));
            }
        }
        return listOfDoubleArrays;
    }

    private List<Point[]> getListOfPointsOfPyramid(List<double[]> listOfDoubleArrays) {
        List<Point[]> listOfPointsOfPyramid = new ArrayList<>();
        for (double[] doubles : listOfDoubleArrays) {
            int iX = 0;
            int iY = 1;
            int iZ = 2;
            int orderPoint = 0;
            Point[] arrayPoint = new Point[5];
            for (int i = 0; i < doubles.length; i += 3) {
                Point point = PointFactory.createPoint(iX + i, iY + i, iZ + i);
                arrayPoint[orderPoint] = point;
                orderPoint++;
            }
            listOfPointsOfPyramid.add(arrayPoint);
        }
        return listOfPointsOfPyramid;
    }

    private List<Pyramid> getListOfPyramid(List<Point[]> listOfPointsOfPyramid) {
        List<Pyramid> listOfPyramid = new ArrayList<>();
        for (Point[] points : listOfPointsOfPyramid) {
            Pyramid pyramid = PyramidFactory.createPyramid(points);
            if (pyramidValidator.isPyramid(pyramid)) {
                listOfPyramid.add(pyramid);
            }
        }
        return listOfPyramid;
    }

}
