package com.paypal.mds.adapter

import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.reflect.SourceType

object CM2Adapter extends App {

  implicit val formats = DefaultFormats

  case class CM2Message(version: Int)

  def CM2Message(json: String): CM2Message = {
    return parse(json).extract[CM2Message]
  }
}