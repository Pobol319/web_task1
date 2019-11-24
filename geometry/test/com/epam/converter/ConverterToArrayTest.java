package com.epam.converter;


import org.junit.Assert;
import org.junit.Test;

public class ConverterToArrayTest {

    @Test
    public void testGetDoubleArray(){
        //given
        String row = "1.0;2.0;3.0";
        double[] expectedArray = {1.0,2.0,3.0};
        ConverterToArray converterToArray = new ConverterToArray();
        //when
        double[] actualArray = converterToArray.getDoubleArray(row);
        //then
        Assert.assertArrayEquals(expectedArray, actualArray, 0.0);
    }

}
