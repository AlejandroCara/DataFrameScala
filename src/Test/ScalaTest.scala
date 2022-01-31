import Comparators.AscendantComparator
import Data.DataFrame
import Factories.CSVReaderFactory
import Predicates.EqualThanPredicate
import Composite.{AComponent, Directory}
import Visitor.{CountVisitor, FilterVisitor}

import java.util
import java.util.List

object MainTest {

  def main(args: Array[String]) = {

    val root = new Directory("Data")
    val df: DataFrame = new DataFrame
    df.readDataFromFile(new CSVReaderFactory("cities.csv"))
    root.addChild(df)

    var subdir = new Directory("SubDit")
    var df2 = new DataFrame();
    df2.readDataFromFile(new CSVReaderFactory("cities.csv"))
    subdir.addChild(df2)
    root.addChild(subdir)

    val column: String = "LatS"
    val column2: String = "LatM"

    var countVisitor = new CountVisitor();
    root.accept(countVisitor);

    def equalString(entry: List[String]): Boolean = entry.get(1).trim == "5";
    var filterVisitor = new FilterVisitor(equalString);
    root.accept(filterVisitor);

    //System.out.println(root.at(1, "State"))
    //System.out.println("Columns: " + root.columns())
    //System.out.println("Rows: " + root.size())
    //System.out.println("Count: " + countVisitor.directoriesCount + " directories and " + countVisitor.dataFrameCount + " dataFrames");
    System.out.println("Filtered: " + filterVisitor.getFiltered())

  }

  def sum(xs: scala.List[AComponent]): Int = {
    if(xs.isEmpty)
      return 0
    else
      return xs.head.size() + sum(xs.tail)
  }

  def list(columns: List[String], values: List[List[String]]): Unit = {
    for(i <- 0 until columns.size()){
      System.out.print(columns.get(i) + "\t")
    }
    System.out.println()
    for (i <- 0 until values.size) {
      for (j <- 0 until columns.size()) {
        System.out.print(values.get(i).get(j) + " ")
      }
      System.out.println()
    }
  }

}