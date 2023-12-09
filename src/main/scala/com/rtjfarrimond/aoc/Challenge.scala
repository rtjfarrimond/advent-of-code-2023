package com.rtjfarrimond.aoc

import scala.io.Source

trait Challenge(val dayNumber: Int) {

  val input: List[String] =
    val dayNumberString =
      if (dayNumber.toString.length == 1) s"0$dayNumber"
      else dayNumber.toString
    val inputResourceName = s"day$dayNumberString.txt"
    Source.fromResource(inputResourceName).getLines().toList

  def part1(input: List[String]): Int | Long

  def part2(input: List[String]): Int | Long

  final def run(): Unit =
    println(s"Part1: ${part1(input)}")
    println(s"Part2: ${part2(input)}")

}
