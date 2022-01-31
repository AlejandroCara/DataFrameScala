package Visitor

import Composite.AComponent
import Data.DataFrame

import java.util

class FilterVisitor(condition: (util.List[String]) => Boolean) extends Visitor {

  private var result: util.List[util.List[String]] = new util.ArrayList[util.List[String]];

  override def visit(component: AComponent): Unit = {
    if(String.valueOf(component.getClass) == "class Data.DataFrame"){
      var dataComponent = component.asInstanceOf[DataFrame];
      var values = dataComponent.getValues();

      for(i <- 0 until values.size()){
        if(condition(values.get(i))){
          this.result.add(values.get(i))
        }
      }
    }

  }

  def getFiltered(): util.List[util.List[String]] = {
    return this.result;
  }
}
