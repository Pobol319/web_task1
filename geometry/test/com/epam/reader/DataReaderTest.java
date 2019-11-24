package com.epam.reader;

import com.epam.exception.DataReaderException;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class DataReaderTest {
    private DataReader dataReader = new DataReader();

    @Test
    public void testGetTextFromFileWithData() throws DataReaderException {
        //given
        final String FILE_WITH_DATA_PATH = "test\\resources\\fileWithDataTest.txt";
        String expectedString = "Hello world";
        //when
        List<String> listOfRowsFromFile = dataReader.getTextFromFile(FILE_WITH_DATA_PATH);
        //then
        Assert.assertEquals(expectedString, listOfRowsFromFile.get(0));
    }

    @Test
    public void testGetTextFromFileWithoutData() throws DataReaderException {
        //given
        final String FILE_WITHOUT_DATA_PATH = "test\\resources\\emptyFileTest.txt";
        //when
        List<String> listOfRowsFromFile = dataReader.getTextFromFile(FILE_WITHOUT_DATA_PATH);
        //then
        Assert.assertTrue(listOfRowsFromFile.isEmpty());
    }
}
