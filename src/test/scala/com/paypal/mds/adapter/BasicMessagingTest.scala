package com.paypal.mds.adapter

import org.scalatest.FunSuite
import scala.collection.mutable.Stack
import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.reflect.SourceType

class BasicMessagingTest extends FunSuite {

  implicit val formats = DefaultFormats

  case class CM2Message(version: Int, `type`: String)

  def ParseCM2Message(messageJSON: String) = { parse(messageJSON).extract[CM2Message] }

  test("extract type from message") {

    val json = """{
			"type": "submitted",
			"timestamp": "2012-01-04 19 18 00 UTC",
			"message_id": "MESSAGE_ID",
			"sequence_id": 1,
			"version": 1,
			"app_id": "campaign_manager",
			"message": {
			    "id": "TEST_ID",
			    "start_date": "2012-01-04 19 19 00 UTC",
			    "end_date": "2012-01-20 19 19 00 UTC",
			    "product_id": 2,
			    "product_type": "Coupon"
	    	}
	   	}
	"""

    assert(ParseCM2Message(json).`type` === "submit")

  }
}
