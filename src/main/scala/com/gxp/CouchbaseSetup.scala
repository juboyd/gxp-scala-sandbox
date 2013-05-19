package com.gxp

import com.couchbase.client.CouchbaseClient
import java.net.URI
import sys.process._

object CouchbaseSetup extends App {

  object Dir {
    
    def cur() = { "pwd".!! }
  }

  def doSetup = {

    val projects = "ls -al /Users/juboyd/Dev" !!
    
    Console.print(projects)
  }

  doSetup
}