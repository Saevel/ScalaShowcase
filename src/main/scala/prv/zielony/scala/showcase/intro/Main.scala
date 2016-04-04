package prv.zielony.scala.showcase.intro

import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
 * Prosty przykla pokazujacy jak wiele można zrobić w Scali w 6 linijkach.
 */
object Main extends App {

  var list:ListBuffer[Int] = ListBuffer.fill(Random.nextInt(200))(Random.nextInt(100))

  println("Lista liczb losowych: ")
  list.foreach(println)

  val divisors = List.range(2, Math.floor(Math.sqrt(list.max)).toInt)
  for (element <- list;divisor <- divisors) {
    if(element % divisor == 0) {
      list = list - element
    }
  }
  val sortedList = list.sorted

  println("\n\nPosortowana lista liczb pierwszych: ")
  sortedList.foreach(println)
}
