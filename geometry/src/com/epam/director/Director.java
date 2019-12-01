package com.epam.director;

import com.epam.converter.ConverterToArray;
import com.epam.entity.Point;
import com.epam.entity.Pyramid;
import com.epam.exception.DataReaderException;
import com.epam.creator.PyramidCreator;
import com.epam.reader.DataReader;
import com.epam.validator.FileDataValidator;
import com.epam.validator.PyramidValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Director {
    private static final String NUMBERS_PATH = "resources\\numbers.txt";
    private DataReader dataReader = new DataReader();
    private ConverterToArray converterToArray = new ConverterToArray();
    private FileDataValidator fileDataValidator = new FileDataValidator();
    private PyramidValidator pyramidValidator = new PyramidValidator();
    private PyramidCreator pyramidCreator = new PyramidCreator(pyramidValidator);

    public List<Pyramid> run() throws DataReaderException {
        List<String> listOfRowsFromFile = dataReader.getTextFromFile(NUMBERS_PATH);
        List<double[]> listOfDoubleArrays = getListOfDoubleArrays(listOfRowsFromFile);
        List<Point[]> listOfPyramidPoints = getListOfPyramidPoints(listOfDoubleArrays);
        return getListOfPyramid(listOfPyramidPoints);
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

    private List<Point[]> getListOfPyramidPoints(List<double[]> listOfDoubleArrays) {
        List<Point[]> listOfPointsOfPyramid = new ArrayList<>();
        for (double[] doubles : listOfDoubleArrays) {
            int iX = 0;
            int iY = 1;
            int iZ = 2;
            int orderPoint = 0;
            Point[] arrayPoint = new Point[5];
            for (int i = 0; i < doubles.length; i += 3) {
                Point point = new Point(doubles[iX + i], doubles[iY + i], doubles[iZ + i]);
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
            Optional<Pyramid> pyramid = pyramidCreator.createPyramid(points);
            pyramid.ifPresent(listOfPyramid::add);
        }
        return listOfPyramid;
    }
}
