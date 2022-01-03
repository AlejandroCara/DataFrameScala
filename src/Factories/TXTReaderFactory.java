package Factories;

import Data.DataFrame;
import Factories.ReaderFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TXTReaderFactory implements ReaderFactory {

    private Path path;

    public TXTReaderFactory(String path) {
        this.path = Path.of(path);
    }

    public DataFrame read(){
        try {

            DataFrame df = new DataFrame();

            BufferedReader br= Files.newBufferedReader(path);
            String firstLine=br.readLine().replace(" \"", "").replace("\"", "");
            if(firstLine!=null) {
                df.setColumns(Arrays.asList(firstLine.split(";")));
                //columns = Arrays.asList(firstLine.split(","));
                df.setValues(br.lines()
                    .map(line -> Arrays.asList(line.split(";")))
                    .collect(Collectors.toList()));
            }

            return df;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
