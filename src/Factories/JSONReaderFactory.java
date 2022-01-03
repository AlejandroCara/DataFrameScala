package Factories;

import Data.DataFrame;
import Factories.ReaderFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class JSONReaderFactory implements ReaderFactory {

    private List<String> columns;
    private List<List<String>> values;
    private Path path;

    //Class to read and save data from csv
    public JSONReaderFactory(String path) {
        this.path = Path.of(path);
    }

    public DataFrame read(){
        FileReader filereader = null;
        try {
            filereader = new FileReader(String.valueOf(path));
            String jsonString = "";
            BufferedReader bufferedreader = new BufferedReader(filereader);
            JSONObject fds;
            String line = bufferedreader.readLine();
            //While we have read in a valid line
            while (line != null) {
                //Acumular las distintas lineas en un solo string
                line = line.trim();
                jsonString+=line;

                line = bufferedreader.readLine();
            }
            //Transformar el string a jsonArray
            JSONArray arr = new JSONArray(jsonString);
            //Coger el primer elemento para recoger los tags
            JSONObject obj = (JSONObject) arr.get(0);

            DataFrame df = new DataFrame();

            //Recoger los tags y setearlos a las columnas
            df.setColumns(obj.keySet().stream().toList());
            List<String> row ;
            for(int i = 0; i < arr.length(); i++){
                obj = (JSONObject) arr.get(i);
                row = new ArrayList<String>();
                for(int j = 0; j < df.numOfTags(); j++){
                    row.add(String.valueOf(obj.get(df.getTagAt(j))));
                }
                df.addValue(row);
            }

            return df;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
