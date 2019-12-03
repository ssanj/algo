package net.ssanj.algo.sorting

object QuickSort extends App {
 
  def quickSort(values: Array[Int], low: Int, high: Int): Unit = {
    if (high > low) {
      val pivotIndex = partition(values, low, high)
      println(s"low=$low, high=$high, pivotIndex=${pivotIndex}, pivot=${values(pivotIndex)}")
      quickSort(values, low, pivotIndex - 1)
      quickSort(values, pivotIndex + 1, high)
    }
  }

  def partition(values: Array[Int], low: Int, high: Int): Int = {
    val pivot = values(high)
    val length = values.length 
    var i = low - 1 //start before j

    for(j <- low until length) { //searchable size is 1 less than length because the pivot is the last element
      if (values(j) < pivot) {
        i = i + 1
        swap(values, j, i)
      }
    }

    swap(values, i + 1, high) //swap the pivot into the correct slow
    i + 1
  }

  def swap(values: Array[Int], index1: Int, index2: Int): Unit = {
    val temp = values(index1)
    values(index1) = values(index2)
    values(index2) = temp
  }

  val arr = Array(10, 30, 80, 90, 40, 50, 70)
  println(s"before: ${arr.mkString(",")}")
  quickSort(arr, 0, arr.length - 1)
  println(s"after: ${arr.mkString(",")}")
}