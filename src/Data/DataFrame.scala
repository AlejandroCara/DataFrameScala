/*package Data

import Comparators.CustomComparator
import Factories.ReaderFactory
import Predicates.CustomPredicate
import Visitor.Visitor
import Composite.AComponent

import java.util
import java.util.{ArrayList, Collections, List}
import java.util.stream.Collectors


class DataFrame() extends AComponent {
  //private  DataFrame this = new DataFrame();
  private var columns = null
  private var values = new util.ArrayList[util.List[String]]

  def readDataFromFile(rf: ReaderFactory): Unit = {
    val df = rf.read
    this.columns = df.getColumns
    this.values = df.getValues
  }

  def setColumns(inColumns: util.List[_]): Unit = {
    this.columns = inColumns
  }

  def setValues(inValues: util.List[util.List[String]]): Unit = {
    this.values = inValues
  }

  def getValues: util.List[util.List[String]] = this.values

  def numOfTags: Int = this.columns.size

  def getTagAt(i: Int): String = this.columns.get(i)

  def getColumns: util.List[String] = this.columns

  def addValue(inValue: util.List[String]): Unit = {
    this.values.add(inValue)
  }

  def at(row: Int, col: String): String = { //List srow = this.values.get(row);
    //int fd = this.columns.indexOf(col);
    this.values.get(row).get(this.columns.indexOf(col))
  }

  def iat(row: Int, col: Int): String = this.values.get(row).get(col)

  def columns: Int = this.columns.size

  def size: Int = this.values.size

  def sort[T](column: String, comparator: CustomComparator[_]): Unit = {
    comparator.setColumnIndex(columns.indexOf(column))
    Collections.sort(values, comparator)
    //Collections.sort(compararator.compare(values.));
  }

  def query(column: String, predicator: CustomPredicate): util.List[util.List[String]] = {
    predicator.setColumnIndex(this.columns.indexOf(column))
    values.stream.filter(predicator).collect(Collectors.toList).asInstanceOf[util.List[util.List[String]]]
  }

  def list(): Unit = {
    for (i <- 0 until this.columns.size) {
      System.out.print(columns.get(i) + "  ")
    }
    System.out.println()
    for (i <- 0 until this.values.size) {
      for (j <- 0 until this.columns.size) {
        System.out.print(this.values.get(i).get(j) + " ")
      }
      System.out.println()
    }
  }

  def accept(v: Visitor): Unit = {
    v.visit(this)
  }
}
*/