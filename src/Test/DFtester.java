package Test;

/*
import Comparators.AscendantComparator;
import Composite.Directory;
import Data.DataFrame;
import Predicates.EqualThanPredicate;
import Factories.CSVReaderFactory;
import Factories.JSONReaderFactory;
import Factories.TXTReaderFactory;
import Visitor.Visitor;

import java.util.List;

public class DFtester {

    public static void main(String[] args) {
        testCSV();
        //testJSON();
        //testTXT();
        //testComposite();
    }

    public static void testCSV(){
        //ReaderFactory reader = new CSVReaderFactory("cities.csv");
        //DataFrame df = reader.read();
        DataFrame df = new DataFrame();
        df.readDataFromFile(new CSVReaderFactory("cities.csv"));
        String column = "LatS";
        String column2 = "LatM";

        System.out.println(df.at(1, "State").trim());
        System.out.println(df.iat(1, 2).trim());
        System.out.println("Columns: " + df.columns());
        System.out.println("Rows: " + df.size());
        df.sort(column, new AscendantComparator());
        //df.list();

        List<List<String>> values = df.query(column2, new EqualThanPredicate(5));
        list(values);
    }

    public static void testJSON(){
        //ReaderFactory reader = new JSONReaderFactory("cities.json");
        //DataFrame df = reader.read();
        DataFrame df = new DataFrame();
        df.readDataFromFile(new JSONReaderFactory("cities.json"));
        String column = "LatS";
        String column2 = "State";

        System.out.println(df.at(1, "State").trim());
        System.out.println(df.iat(1, 2).trim());
        System.out.println("Columns: " + df.columns());
        System.out.println("Rows: " + df.size());
        df.sort(column, new AscendantComparator());

        List<List<String>> values = df.query(column2, new EqualThanPredicate("ND"));
        list(values);
    }

    public static void testTXT(){
        //ReaderFactory reader = new TXTReaderFactory("cities.txt");
        //DataFrame df = reader.read();
        DataFrame df = new DataFrame();
        df.readDataFromFile(new TXTReaderFactory("cities.txt"));
        String column = "LatS";
        int indexOfColumn;

        System.out.println(df.at(1, "State").trim());
        System.out.println(df.iat(1, 2).trim());
        System.out.println("Columns: " + df.columns());
        System.out.println("Rows: " + df.size());
        indexOfColumn = df.getColumns().indexOf(column);
        df.sort(column, new AscendantComparator());
        df.list();
    }

    public static void testComposite(){
        Directory root = new Directory("C:");
        DataFrame df = new DataFrame();
        df.readDataFromFile(new CSVReaderFactory("cities.csv"));

        root.addChild(df);

    }

    public static void list(List<List<String>> values){
        System.out.println();
        for (int i = 0; i < values.size(); i++){
            for(int j = 0; j < 10; j++){
                System.out.print(values.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}*/
