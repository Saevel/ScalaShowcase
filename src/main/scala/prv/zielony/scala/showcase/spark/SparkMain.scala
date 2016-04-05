package prv.zielony.scala.showcase.spark

import org.apache.spark.SparkContext

/**
 * Created by zielony on 27.03.16.
 */
object SparkMain extends App {

  val sparkContext = new SparkContext("local[*]", "Scala-Showcase")

  val loremFile = sparkContext.textFile("lorem_ipsum.txt")

  val words = loremFile
    .flatMap { line =>
      line.split(" ")
    }.filter { wordOrSign =>
      wordOrSign != "." && wordOrSign != ","
    }.map(removeDiracticalMarks)

  val wordCounts = words
    .map { word =>
      (word, 1)
    } .reduceByKey { (value1, value2) =>
      value1 + value2
    }

  println("Results:")
  wordCounts.foreach { pair =>
    val (word, count) = pair
    println("Word: " + word + ". Count: " + count)
  }

  def removeDiracticalMarks(in:String):String = {
    var result = in;
    if(result.contains(".")) {
      result = result.replaceAll(".", "")
    }
    if(result.contains(",")) {
      result = result.replaceAll(",", "")
    }

    result
  }
}