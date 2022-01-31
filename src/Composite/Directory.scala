package Composite

import Comparators.CustomComparator
import Data.DataFrame
import Predicates.CustomPredicate
import Visitor.Visitor
import Composite.AComponent


import java.util
import java.util.{ArrayList, List}

class Directory(var name: String) extends AComponent {

  private var childs: List[AComponent] = new ArrayList[AComponent]

  def addChild(c: AComponent): Unit = {
    this.childs.add(c)
  }

  override def at(row: Int, col: String): List[String] = {
    var result : List[String] = new util.ArrayList[String]();
    for(i <- 0 until childs.size()){
      result.addAll(childs.get(i).at(row, col))
    }
    return result
  }

  override def columns(): Int = {
    var result = 0
    for(i <- 0 until childs.size()){
      result += childs.get(i).columns();
    }
    return result
  }

  override def size(): Int = {
    var result = 0
    for(i <- 0 until childs.size()){
      result += childs.get(i).size()
    }
    return result
  }

  override def accept(v: Visitor): Unit = {
    v.visit(this);
    for(i <- 0 until childs.size()){
      childs.get(i).accept(v)
    }
  }



}
