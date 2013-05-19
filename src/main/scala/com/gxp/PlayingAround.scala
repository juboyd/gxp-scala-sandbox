package com.gxp

object MyFormat {

  def makeSomeSpace(s: String) {
    Console.println("\n\n*************")
    Console.println("***** %s *****".format(s))
    Console.println("*************\n\n")
  }
}

object PlayingAround extends App {

  case class Person(name: String)

  val meNameMatcher = (name: String) => {
    val result = name match {
      case "justin" => "it's Me!"
      case "katie" => "it's my wife!"
      case _ => "it's someone else"
    }
    System.out.println(result)
  }

  val mePersonMatcher = (person: Person) => {
    
    meNameMatcher(person.name)
  }

  def playingWithMatching = {

    MyFormat.makeSomeSpace("matching")

    mePersonMatcher(new Person("justin"))
    mePersonMatcher(new Person("katie"))
    mePersonMatcher(new Person("dave"))
  }

  def playingWithCollections = {

    MyFormat.makeSomeSpace("collections")

    val people = List(new Person("justin"), new Person("katie"), new Person("dave"))

    people foreach mePersonMatcher
  }

  def playingWithConverters = {
    MyFormat.makeSomeSpace("converters")

    implicit def strToPerson(name: String) = {
      new Person(name)
    }
    
    mePersonMatcher("dan")
  }

  playingWithMatching
  playingWithCollections
  playingWithConverters
}

