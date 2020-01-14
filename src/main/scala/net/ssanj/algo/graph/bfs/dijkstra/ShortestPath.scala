package net.ssanj.algo.graph.bfs.dijkstra
import scala.collection.mutable.ListBuffer
import scala.collection._

object ShortestPath extends App {

  val startNode = "start"
  val aNode = "a"
  val bNode = "b"
  val finNode = "fin"

  val unfilledNode = "unfilled"

  val unprocessedNodes: ListBuffer[String] = new ListBuffer() ++= List(startNode, aNode, bNode)

  val graph: mutable.Map[String, mutable.Map[String, Int]] = 
    mutable.Map(
      startNode -> mutable.Map(aNode   -> 6, bNode   -> 2),
      aNode     -> mutable.Map(finNode -> 1),
      bNode     -> mutable.Map(aNode   -> 3, finNode -> 5),
      finNode   -> mutable.Map()
    )

  val costs: mutable.Map[String, Int] = mutable.Map(aNode -> 6, bNode -> 2, finNode -> Integer.MAX_VALUE)

  val parents: mutable.Map[String, String] = 
    mutable.Map(
      aNode   -> startNode,
      bNode   -> startNode,
      finNode -> unfilledNode
    )

  def findLowestCostNode(costs: mutable.Map[String, Int]): String = {
    var lowestCost = Integer.MAX_VALUE
    var lowestCostNode: String = null //crimes against humanity

    for ((n, c) <- costs) {
      println("findLowestCostNode:loop")
      if (c < lowestCost && unprocessedNodes.contains(n)) {
        lowestCost = c
        lowestCostNode = n
      } else {} //continue
    }

    println(s"lowestcodenode: $lowestCostNode")
    lowestCostNode
  }

  var node = findLowestCostNode(costs)
  
  while (node != null) {
    println("while:loop: ")
    val cost = costs(node)
    val nebs = graph(node)

    for ((nebNode, nebCost) <- nebs) {
      println(s"while:for:$cost -> $nebNode:$nebCost")
      val newCost = cost + nebCost
      if (costs(nebNode) > newCost) {
        costs(nebNode) = newCost
        parents(nebNode) = node
      } else {}
    }

    unprocessedNodes -= node
    node = findLowestCostNode(costs)
  }

  println(s"costs:\n\t${costs.mkString(",")}")
  println(s"parents:\n\t${parents.mkString(",")}")
}