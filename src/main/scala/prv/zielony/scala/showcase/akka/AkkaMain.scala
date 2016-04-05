package prv.zielony.scala.showcase.akka

import akka.actor.{ActorSystem, Props}
import akka.util.Timeout
import akka.pattern.ask

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration._

/**
 * Główna klasa aplikacji Akki.
 */
object AkkaMain extends App {

  implicit val system = ActorSystem("Akka-Showcase")

  implicit val timeout = Timeout(10)

  val target = """
       Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
       magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
       consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
       Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum
    """

  val chars = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
    'u', 'v', 'w', 'x', 'y', 'z')

  val actors = chars.map { char =>
    (char, system.actorOf(Props(new CharCountActor(char))))
  }

  val startTime = System.nanoTime()

  val results = actors.map { pair =>
    val (char, actor) = pair
    (char, Await.result(actor ? target, timeout.duration).asInstanceOf[Int])
  }

  val endTime = System.nanoTime();

  println("Results: ")
  results.foreach { pair =>
    val (char, count) = pair
    println("Char: " + char + ". Count: " + count)
  }

  println("Czas wykonania: " + (endTime - startTime) * Math.pow(10, -9) + " sekundy")
}