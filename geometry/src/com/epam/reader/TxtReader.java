package com.epam.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtReader {

    public List<String> getTextFromFile(String path) {
        File file = new File(path);
        List<String> listOfRowsFromFile = new ArrayList<>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                listOfRowsFromFile.add(temp);
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
        return listOfRowsFromFile;
    }

}
