package day01

import scala.io.Source

object day01 extends App{
  val input = Source.fromResource("day01.txt").mkString.toList.map {
    case '(' => 1
    case ')' => -1
  }

  println("Part 1: ", input.sum)

  var currentFloor = 0
  var currentPosition = 0
  var basementPosition = 0
  var found = false

  for(change <- input) {
    if (!found) {
      currentPosition += 1
      currentFloor += change

      if (currentFloor == -1) {
        basementPosition = currentPosition
        found = true
      }
    }
  }

  println("Part 2: ", basementPosition)
}
