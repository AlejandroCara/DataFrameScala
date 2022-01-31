package Test;

import Data.DataFrame;
import Factories.CSVReaderFactory;
import Factories.TXTReaderFactory;
import Predicates.EqualThanPredicate;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TXTTester {

    @Test
    public void testRead(){
        DataFrame df = new DataFrame();
        df.readDataFromFile(new TXTReaderFactory("cities.txt"));
        Assert.assertNotNull(df.getValues());
    }

    @Test
    public void testAt(){
        DataFrame df = new DataFrame();
        df.readDataFromFile(new TXTReaderFactory("cities.txt"));
        Assert.assertEquals("SD", df.at(1, "State"));
    }

    @Test
    public void testIat(){
        DataFrame df = new DataFrame();
        df.readDataFromFile(new TXTReaderFactory("cities.txt"));
        Assert.assertEquals("SD", df.iat(1, 9));
    }

    @Test
    public void testColumns(){
        DataFrame df = new DataFrame();
        df.readDataFromFile(new TXTReaderFactory("cities.txt"));
        Assert.assertEquals(10, df.columns());
    }

    @Test
    public void testSize(){
        DataFrame df = new DataFrame();
        df.readDataFromFile(new TXTReaderFactory("cities.txt"));
        List<List<String>> values = df.query("State", new EqualThanPredicate("SD"));
        Assert.assertEquals("SD", values.get(0).get(9));
    }

}
