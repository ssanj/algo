package net.ssanj.algo.sorting

object QuickSort2 extends App {


  def quicksort(values: Array[Int]): Array[Int] = {
    if (values.length < 2) values
    else {
      val pivot = values(0)
      val less = values.tail.filter(_ <= pivot)
      val gt = values.tail.filter(_ > pivot)

      quicksort(less) ++ Array(pivot) ++ quicksort(gt)
    }

  }

  println(s"sorted: ${quicksort(Array(8,6,4,1,5)).mkString(",")}")
  println(s"sorted: ${quicksort(Array(10, 5, 2, 3)).mkString(",")}")
  println(s"sorted: ${quicksort((1000 to 1 by -1).toArray).mkString(",")}")
}