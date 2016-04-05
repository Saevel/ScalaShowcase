package prv.zielony.scala.showcase.akka

import akka.actor.Actor
import akka.actor.Actor.Receive

/**
  * Created by kowczarek on 2016-04-05.
  */
class CharCountActor(targetChar:Char) extends Actor {

  override def receive: Receive = {
    case text:String => {
      var count = 0;
      for(character <- text) {
        if(character == targetChar) {
          count = count + 1
        }
      }

      sender ! count
    }
  }
}
