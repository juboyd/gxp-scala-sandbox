package com.gxp.akka

import akka.actor.Actor
import akka.event.Logging

class Hodor extends Actor {

  val log = Logging(context.system, this)
  
  def excited : Receive = {
    
    case _ => log.info("HODOR!!! HODOR!!!")
  }

  def receive = {
    case "test" => log.info("Hodor!")
    case "hodor" => {
      log.info("HODOR!!!")
      context.become( excited, false )
    }
    case _ => log.info("Hodor???")
  }
  
  
}