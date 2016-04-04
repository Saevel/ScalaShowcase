package prv.zielony.scala.showcase.akka

import akka.actor.ActorSystem

/**
 * Created by zielony on 27.03.16.
 */
class AkkaMain extends App {

  implicit val system = ActorSystem("Akka-Showcase")

  

}
