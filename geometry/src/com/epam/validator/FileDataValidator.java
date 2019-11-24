package com.epam.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileDataValidator {
    private static final int REQUIRED_NUMBER_OF_DOUBLES = 15;
    private static final String VALID_POINT = "-?[0-9]+\\.?[0-9]*";

    public boolean isValidRow(String temp) {
        if (temp == null) {
            return false;
        }
        if (temp.isEmpty()) {
            return false;
        }
        String[] splitRow = temp.split(";");
        if (splitRow.length < REQUIRED_NUMBER_OF_DOUBLES || splitRow.length > REQUIRED_NUMBER_OF_DOUBLES) {
            return false;
        }
        Pattern pattern = Pattern.compile(VALID_POINT);
        Matcher matcher;
        for (String point : splitRow) {
            matcher = pattern.matcher(point);
            if (!matcher.matches()) {
                return false;
            }
        }
        return true;
    }
}
