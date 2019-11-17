package com.epam.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.constants.PyramidConstants.REQUIRED_NUMBER_OF_DOUBLES;
import static com.epam.constants.RegularExpressions.VALID_POINT;

public class FileDataValidator {
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
