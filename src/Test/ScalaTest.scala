import Comparators.AscendantComparator
import Data.DataFrame
import Factories.CSVReaderFactory
import Predicates.EqualThanPredicate

import java.util
import java.util.List

object MainTest {

  def main(args: Array[String]) = {

    val df: DataFrame = new DataFrame
    df.readDataFromFile(new CSVReaderFactory("cities.csv"))
    val column: String = "LatS"
    val column2: String = "LatM"

    System.out.println(df.at(1, "State").trim)
    System.out.println("Columns: " + df.columns)
    System.out.println("Rows: " + df.size)
    //df.list();
    list(df.getValues)
  }


  def list(values: util.List[util.List[String]]): Unit = {
    System.out.println()
    for (i <- 0 until values.size) {
      for (j <- 0 until 10) {
        System.out.print(values.get(i).get(j) + " ")
      }
      System.out.println()
    }
  }
}