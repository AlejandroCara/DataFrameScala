package Composite

import Visitor.Visitor

trait AComponent {
  def at(row:Int, col:String):String
  def columns():Int
  def size():Int
  def accept(v:Visitor): Unit
}
