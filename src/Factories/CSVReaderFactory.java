package Factories;

import Data.DataFrame;
import Factories.ReaderFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CSVReaderFactory implements ReaderFactory {

    private Path path;

    //Class to read and save data from csv
    public CSVReaderFactory(String path){
        this.path = Path.of(path);
    }

    public DataFrame read(){
        DataFrame df = new DataFrame();
        try {
            BufferedReader br= Files.newBufferedReader(path);
            String firstLine=br.readLine().replace(" \"", "").replace("\"", "");
            if(firstLine!=null) {
                df.setColumns(Arrays.asList(firstLine.split(",")));
                //columns = Arrays.asList(firstLine.split(","));
                df.setValues(br.lines()
                    .map(line -> Arrays.asList(line.split(",")))
                    .collect(Collectors.toList()));
            }
            return df;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
