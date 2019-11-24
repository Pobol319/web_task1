package com.epam.reader;

import com.epam.exception.DataReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class DataReader {
    private static final Logger LOG = LogManager.getLogger(DataReader.class);

    public List<String> getTextFromFile(String path) throws DataReaderException {
        File file = new File(path);
        List<String> listOfRowsFromFile = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                listOfRowsFromFile.add(temp);
            }
        } catch (FileNotFoundException e) {
            throw new DataReaderException("File not found",e);
        } catch (IOException e) {
            throw new DataReaderException("Problem reading file",e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                LOG.error("Error with closing file", e);
            }
        }
        return listOfRowsFromFile;
    }

}
