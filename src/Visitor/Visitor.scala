package Visitor

import Composite.AComponent

trait Visitor {
  def visit(component:AComponent): Unit
}
