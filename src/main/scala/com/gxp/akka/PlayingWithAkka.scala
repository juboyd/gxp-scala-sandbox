package com.gxp.akka

import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor
import akka.event.Logging
import java.util.concurrent.TimeUnit

object PlayingWithAkka extends App {

  val mySystem = ActorSystem("MyActorSystem")

  Console.println("getting started with a new actor system")

  val hodor = mySystem.actorOf(Props[Hodor], name = "Hodor")

  hodor ! "hey"
  hodor ! "test"
  hodor ! "hodor"
  hodor ! "hey"
  hodor ! "hodor?"

  TimeUnit.SECONDS.sleep(1L)

  var ok = true
  while (ok) {
    val userInput = readLine()
    ok = userInput != "quit"
    if (ok) hodor ! userInput
  }
  mySystem.shutdown()
}

 
