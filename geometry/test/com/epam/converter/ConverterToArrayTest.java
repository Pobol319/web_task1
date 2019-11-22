package com.epam.converter;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ConverterToArrayTest {

    @Test
    public void getDoubleArrayTest(){
        String row = "1.0;2.0;3.0";
        double[] expectedArray = {1.0,2.0,3.0};
        ConverterToArray converterToArray = new ConverterToArray();
        double[] actualArray = converterToArray.getDoubleArray(row);
        Assert.assertArrayEquals(expectedArray, actualArray, 0.0);
    }

}
