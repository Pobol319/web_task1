package com.epam;

import com.epam.converter.ConverterToArray;
import com.epam.entity.Point;
import com.epam.factory.PointFactory;
import com.epam.reader.TxtReader;
import com.epam.validator.FileDataValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String NUMBERS_PATH = "resources\\numbers.txt";

    public static void main(String[] args) {
        TxtReader txtReader = new TxtReader();
        ConverterToArray converterToArray = new ConverterToArray();
        FileDataValidator fileDataValidator = new FileDataValidator();

        List<String> listOfRowsFromFile = txtReader.getTextFromFile(NUMBERS_PATH);
        List<double[]> listOfDoubleArrays = new ArrayList<>();
        List<Point> listOfPointsOfPyramid = new ArrayList<>();


        for (String temp : listOfRowsFromFile) {
            if (fileDataValidator.isValidRow(temp)) {
                listOfDoubleArrays.add(converterToArray.getDoubleArray(temp));
            }
        }

        for (double[] doubles : listOfDoubleArrays) {
            int iX = 0;
            int iY = 1;
            int iZ = 2;
            for (int i = 0; i < doubles.length; i += 3) {
                Point point = PointFactory.createPoint(iX + i, iY + i, iZ + i);
                listOfPointsOfPyramid.add(point);
            }
        }

        for (double[] array : listOfDoubleArrays) {
            System.out.println(Arrays.toString(array));
        }


    }
}
