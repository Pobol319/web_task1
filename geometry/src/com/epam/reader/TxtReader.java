package com.epam.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtReader {

    public List<String> getTextFromFile(File file) {
        List<String> listOfPoints = new ArrayList<String>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                listOfPoints.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace(); // заменить
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listOfPoints;
    }

}
