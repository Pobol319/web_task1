package com.epam.converter;

import java.util.ArrayList;
import java.util.List;

public class ConverterToArray {

    public double[] getDoubleArray(String row) {
        String[] arrayOfStringNumbers = row.split("[;]");
        double[] arrayOfDoubleNumbers = new double[arrayOfStringNumbers.length];

        for (int i = 0; i < arrayOfStringNumbers.length; i++) {
            arrayOfDoubleNumbers[i] = Double.parseDouble(arrayOfStringNumbers[i]);
        }
        return arrayOfDoubleNumbers;
    }
}
