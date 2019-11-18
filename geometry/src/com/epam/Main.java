package com.epam;

import com.epam.converter.ConverterToArray;
import com.epam.entity.Point;
import com.epam.entity.Pyramid;
import com.epam.factory.PointFactory;
import com.epam.factory.PyramidFactory;
import com.epam.reader.TxtReader;
import com.epam.validator.FileDataValidator;
import com.epam.validator.PyramidValidator;

import java.util.ArrayList;
import java.util.List;


public class Main {
    private static final String NUMBERS_PATH = "resources\\numbers.txt";

    public static void main(String[] args) {
        TxtReader txtReader = new TxtReader();
        ConverterToArray converterToArray = new ConverterToArray();
        FileDataValidator fileDataValidator = new FileDataValidator();
        PyramidValidator pyramidValidator = new PyramidValidator();

        List<String> listOfRowsFromFile = txtReader.getTextFromFile(NUMBERS_PATH);
        List<double[]> listOfDoubleArrays = new ArrayList<>();
        List<Point[]> listOfPointsOfPyramid = new ArrayList<>();
        List<Pyramid> listOfPyramid = new ArrayList<>();

        for (String temp : listOfRowsFromFile) {
            if (fileDataValidator.isValidRow(temp)) {
                listOfDoubleArrays.add(converterToArray.getDoubleArray(temp));
            }
        }

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

        for (Point[] points : listOfPointsOfPyramid) {
            Pyramid pyramid = PyramidFactory.createPyramid(points);
            if (pyramidValidator.isValidPyramid(pyramid)) {
                listOfPyramid.add(pyramid);
            }
        }

    }
}
