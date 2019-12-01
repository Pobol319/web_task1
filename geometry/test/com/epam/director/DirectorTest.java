package com.epam.director;

import com.epam.converter.ConverterToArray;
import com.epam.creator.PyramidCreator;
import com.epam.reader.DataReader;
import com.epam.validator.FileDataValidator;
import com.epam.validator.PyramidValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DirectorTest {

    @Test
    public void testRunReturnListOfPyramid() {

        DataReader dataReader = Mockito.mock(DataReader.class);
        ConverterToArray converterToArray = Mockito.mock(ConverterToArray.class);
        FileDataValidator fileDataValidator;
        PyramidValidator pyramidValidator;
        PyramidCreator pyramidCreator;

    }
}
