package day02

import scala.io.Source

object day02 extends App{
  def surfaceArea = (dimensions: Array[Int]) => {
    val height = dimensions(0)
    val width = dimensions(1)
    val length = dimensions(2)
    val smallestSide = dimensions.min

    val side1 = height * width
    val side2 = width * length
    val side3 = length * height

    (2 * side1) + (2 * side2) + (2 * side3) + List(side1, side2, side3).min
  }

  val input = Source.fromResource("day02.txt").getLines.toList.map(_.split("x").map(_.toInt))

  println("Part 1: ", input.map(dimensions => surfaceArea(dimensions)).sum)

  def ribbonLengthFor = (dimensions: Array[Int]) => {
    val sortedDimensions = dimensions.sorted
    val length = sortedDimensions(0)
    val width = sortedDimensions(1)
    val height = sortedDimensions(2)

    val ribbonToWrap = length + length + width + width
    val ribbonForBow = sortedDimensions.product

    ribbonToWrap + ribbonForBow
  }

  println("Part 2: ", input.map(dimensions => ribbonLengthFor(dimensions)).sum)
}
