package net.ssanj.algo.levenshteinDistance

object Standard extends App {

  private def lDistance(s1: String, s2: String): Int = {

    val rows = s1.length + 1
    val cols = s2.length + 1
    val deletionCost      = 1
    val insertionCost     = 1

    val matrix: Array[Array[Int]] = Array.fill(rows, cols)(0)

    //set the String indexes
    for (r <- (1 until rows)) {      
      matrix(r)(0) = r
    }
    
    for (c <- (1 until cols)) {
      matrix(0)(c) = c
    }

    for (r <- 1 until rows) { 
        for (c <- 1 until cols) {
          val transpositionCost = if (s1(r - 1) == s2(c - 1)) 0 else 1
          val deletion      = matrix(r - 1)(c) + deletionCost
          val addition      = matrix(r)(c - 1) + insertionCost
          val transposition = matrix(r - 1)(c - 1) + transpositionCost

          matrix(r)(c) = Math.min(Math.min(deletion, addition), transposition)
          
      }
    }

    println(prettyMatrix(matrix))

    matrix(rows - 1)(cols - 1)
  }

  private def prettyMatrix(matrix: Array[Array[Int]]): String = {
    matrix.map(_.mkString(",")).mkString("\n")
  }


  val str1 = "Saturday"
  val str2 = "Sunday"

  val distance = lDistance(str1, str2)
  println(s"Levenshtein distance between ${str1} and ${str2} is: ${distance}")
}