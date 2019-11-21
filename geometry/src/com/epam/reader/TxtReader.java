package com.epam.reader;

import com.epam.exception.TxtReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TxtReader {
    private static final Logger LOG = LogManager.getLogger(TxtReader.class);

    public List<String> getTextFromFile(String path) throws TxtReaderException {
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
            LOG.error("Problem in TxtReader");
            throw new TxtReaderException(e);
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
