package com.epam.validator;

import org.junit.Assert;
import org.junit.Test;

public class FileDataValidatorTest {
    private FileDataValidator fileDataValidator = new FileDataValidator();

    @Test
    public void isValidRowNegativeTestWithNull(){
        Assert.assertFalse(fileDataValidator.isValidRow(null));
    }

    @Test
    public void isValidRowNegativeTestWithEmptyRow(){
        Assert.assertFalse(fileDataValidator.isValidRow(""));
    }

    @Test
    public void isValidRowNegativeTestWithIllegalRow(){
        Assert.assertFalse(fileDataValidator.isValidRow("2.0;4.0;-3.0;6;4;-3;6;8;-3;2;8;-3;4;6;4;12;13"));
    }

    @Test public void isValidRowPositiveTest(){
        Assert.assertTrue(fileDataValidator.isValidRow("2.0;4.0;-3.0;6;4;-3;6;8;-3;2;8;-3;4;6;4"));
    }
}
