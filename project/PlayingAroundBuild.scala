import sbt._
import sbt.Keys._

object PlayingAroundBuild extends Build {

  lazy val playingAround = Project(
    id = "playing-around",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "Playing Around",
      organization := "com.gxp",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.9.2",
      resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases",
      resolvers += "Couchbase Maven Repository" at "http://files.couchbase.com/maven2",
      resolvers += "Maven Central" at "http://repo1.maven.org/maven2/",
      resolvers += "Nexus Snapshots" at "http://nexus.paypal.com/nexus/content/repositories/snapshots",
      libraryDependencies += "com.typesafe.akka" % "akka-actor" % "2.0.1",
      libraryDependencies += "couchbase" % "couchbase-client" % "1.1-dp4",
      libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.1" % "test",
      libraryDependencies += "org.scalatra" %% "scalatra-json" % "2.2.1",
      libraryDependencies += "org.json4s"   %% "json4s-jackson" % "3.2.4"
    )
  )
}

