package com.epam;

import com.epam.reader.TxtReader;

import java.util.List;

public class Main {
    private static final String NUMBERS_PATH = "resources\\numbers.txt";

    public static void main(String[] args) {
        TxtReader txtReader = new TxtReader();
        List<String> listOfPointsTxt = txtReader.getTextFromFile(NUMBERS_PATH);

    }
}
