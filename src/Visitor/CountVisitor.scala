package Visitor

import Composite.AComponent

class CountVisitor extends Visitor{

  var directoriesCount: Int = 0;
  var dataFrameCount: Int = 0;

  override def visit(component: AComponent): Unit = {
    if(String.valueOf(component.getClass) == "class Composite.Directory"){
      this.directoriesCount+=1;
    } else {
      this.dataFrameCount+=1;
    }
  }

  def getDirectoriesCount(): Int = {
    return this.directoriesCount;
  }

  def getDataFrameCount(): Int = {
    return this.dataFrameCount;
  }
}

