import Comparators.AscendantComparator
import Data.DataFrame
import Factories.CSVReaderFactory
import Predicates.EqualThanPredicate
import Composite.{AComponent, Directory}
import Visitor.{CountVisitor, FilterVisitor}
import scala.jdk.CollectionConverters._
import scala.collection.mutable.ListBuffer

import java.util
import java.util.List
import java.util.{ArrayList, List}

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

    System.out.println(root.at(1, "State"))
    System.out.println("Columns: " + root.columns())
    System.out.println("Rows: " + root.size())
    System.out.println("Count: " + countVisitor.directoriesCount + " directories and " + countVisitor.dataFrameCount + " dataFrames");
    System.out.println("Filtered: " + filterVisitor.getFiltered())

    //System.out.println(df.getColumntAsList("LatM"))
    var list = df.getColumntAsList("LatM").asScala.toList
    def filter(x: String):Boolean = x.toInt > 49;
    def operation(x: String):Int = x.toInt + 100
    var returnList = filterMap(filter, operation, list)
    System.out.println(returnList)

    //System.out.println(df.getColumntAsList("LatM"))
    var accumulator = scala.List();
    var listTail = df.getColumntAsList("LatM").asScala.toList
    def filterTail(x: String):Boolean = x.toInt > 49;
    def operationTail(x: String):Int = x.toInt + 100
    var returnlistTail = filterMap(filterTail, operationTail, listTail, accumulator);
    System.out.println(returnlistTail) //Sames values that stack but backwards

  }

  def filterMap[T, S](filter: (T => Boolean), operation: (T => S), list: scala.List[T]): scala.List[S] = list match {
    case Nil => Nil
    case h::t => if(filter(h)) {
                    operation(h)::filterMap(filter, operation, t)
                 } else {
                    filterMap(filter, operation, t)
                 }
  }

  def filterMap[T, S](filter: (T => Boolean), operation: (T => S), list: scala.List[T], result: scala.List[S]): scala.List[S] = list match {
    case Nil => result
    case h::t =>if(filter(h)) {
                  filterMap(filter, operation, t, operation(h)::result)
                } else {
                  filterMap(filter, operation, t, result)
                }
  }
}