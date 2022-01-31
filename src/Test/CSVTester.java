package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Data.DataFrame;
import Factories.CSVReaderFactory;
import Predicates.EqualThanPredicate;
import org.junit.*;

import java.util.List;

public class CSVTester {

    @Test
    public void testRead(){
        DataFrame df = new DataFrame();
        df.readDataFromFile(new CSVReaderFactory("cities.csv"));
        Assert.assertNotNull(df.getValues());
    }

    @Test
    public void testAt(){
        DataFrame df = new DataFrame();
        df.readDataFromFile(new CSVReaderFactory("cities.csv"));
        Assert.assertEquals("SD", df.at(1, "State"));
    }

    @Test
    public void testIat(){
        DataFrame df = new DataFrame();
        df.readDataFromFile(new CSVReaderFactory("cities.csv"));
        Assert.assertEquals("SD", df.iat(1, 9));
    }

    @Test
    public void testColumns(){
        DataFrame df = new DataFrame();
        df.readDataFromFile(new CSVReaderFactory("cities.csv"));
        Assert.assertEquals(10, df.columns());
    }

    @Test
    public void testSize(){
        DataFrame df = new DataFrame();
        df.readDataFromFile(new CSVReaderFactory("cities.csv"));
        List<List<String>> values = df.query("State", new EqualThanPredicate("SD"));
        Assert.assertEquals("SD", values.get(0).get(9));
    }

}
