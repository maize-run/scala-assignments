package funsets

import FunSets._

object week2 {
import FunSets._
  val sall = (el:Int) => if (el >= -1000 && el <= 1000) true else false
                                                  //> sall  : Int => Boolean = <function1>
  val s14 = (el:Int) => if (el >= 1 && el <= 4) true else false
                                                  //> s14  : Int => Boolean = <function1>
  printSet(s14)                                   //> {1,2,3,4}
  forall(filter(sall, _%2 == 0), _%2 == 0)        //> res0: Boolean = true
  exists(s14, _>3)                                //> res1: Boolean = true
  printSet(map(s14, _*3))                         //> {3,6,9,12}
}