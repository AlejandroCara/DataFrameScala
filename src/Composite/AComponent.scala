package Composite

import Visitor.Visitor

import java.util.List

trait AComponent {
  def at(row:Int, col:String): List[String]
  def columns():Int
  def size():Int
  def accept(v:Visitor): Unit
}
