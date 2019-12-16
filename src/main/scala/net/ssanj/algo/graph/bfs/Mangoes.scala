package net.ssanj.algo.graph.bfs

import scala.collection.mutable.Queue
import scala.collection.mutable.HashMap

object Managoes extends App {

  val graph: HashMap[String, Array[String]] = HashMap()
  graph += (
    ("you", Array("alice", "bob", "claire")),
    ("bob", Array("anuj", "peggy")),
    ("alice", Array("peggy")),
    ("claire", Array("thom", "jonny")),
    ("anuj", Array()),
    ("peggy", Array()),
    ("thom", Array()),
    ("jonny", Array())
  )

  println(graph.map(kv => s"${kv._1}->${kv._2.mkString(",")}\n").mkString)

  val q = Queue[String](graph("you"):_*)

  def doesSellManagoes(person: String): Boolean = person.endsWith("m")

  var alreadySearched = Array[String]()
  //store previous results
  def findMangoSeller(): Option[String] = { 
    while (!q.isEmpty) {
      val person = q.dequeue()     
      println(s"checking: $person from q: $q")
      println(s"already searched: ${alreadySearched.mkString(",")}")      
      if (!alreadySearched.contains(person)) {
        alreadySearched = alreadySearched :+ person
        if (doesSellManagoes(person)) return Some(person)
        else {
          q.enqueue(graph(person):_*)
          println(s"added neighbours for: $person in q: $q")
        }
      } else println(s"already searched $person from search array: ${alreadySearched.mkString(",")}")
    }

    return None
  }

  println(s"found a mango seller: ${findMangoSeller()}")
}