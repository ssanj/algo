package net.ssanj.algo.sorting

object SelectionSort extends App {

  private def selectionSort[A](sort: (Int, Int) => Boolean, array: Array[Int]): Unit = {
    var temp = -1
    for (i <- 0 until array.length) {
      for (j <- (i + 1) until array.length) {
        if (sort(array(i), array(j))) {
          temp = array(i)
          array(i) = array(j)
          array(j) = temp
        }

        println(s"i=${i},j=${j} ${array.mkString(",")}")
      }
    }
  }


  private val values = Array(3, 12, 7, 10, 5)

  println(s"before sorting: ${values.mkString(",")}")
  selectionSort((a, b) => a < b, values)
  println(s"after sorting dec: ${values.mkString(",")}")
  selectionSort((a, b) => a > b, values)
  println(s"after sorting asc: ${values.mkString(",")}")
}