package com.epam.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.constans.RegularExpressions.VALID_POINT;

public class FileDataValidator {

    public boolean isValidPoints(String temp) {
        Pattern pattern = Pattern.compile(VALID_POINT);
        String[] points = temp.split(";");
        Matcher matcher;
        for(String point : points){
            matcher = pattern.matcher(point);
            if(!matcher.matches()){
                return false;
            }
        }
        return true;
    }

}
