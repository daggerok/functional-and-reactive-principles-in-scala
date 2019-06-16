package com.github.daggerok

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class HigherOrderFunctionsTest {
  @Test def test_sum_of_cubes(): Unit = {
    def cube(x: Int) = x * x * x
    def sumOfCubes(a: Int, b: Int): Int =
      if (a > b) 0 else cube(a) + sumOfCubes(a + 1, b)

    println(s"sumOfCubes(1, 1) = ${sumOfCubes(1, 1)}")
    println(s"sumOfCubes(2, 2) = ${sumOfCubes(2, 2)}")
    println(s"sumOfCubes(1, 2) = ${sumOfCubes(1, 2)}")
    println(s"sumOfCubes(3, 3) = ${sumOfCubes(3, 3)}")
    println(s"sumOfCubes(2, 3) = ${sumOfCubes(2, 3)}")
    println(s"sumOfCubes(1, 3) = ${sumOfCubes(1, 3)}")

    assertAll("tests should pass",
      () => assertEquals(1, sumOfCubes(1, 1)),
      () => assertEquals(8, sumOfCubes(2, 2)),
      () => assertEquals(9, sumOfCubes(1, 2)),
      () => assertEquals(27, sumOfCubes(3, 3)),
      () => assertEquals(35, sumOfCubes(2, 3)),
      () => assertEquals(36, sumOfCubes(1, 3)),
    )
  }

  @Test def test_sum_of_integers(): Unit = {
    def sumOfIntegers(a: Int, b: Int): Int =
      if (a > b) 0 else a + sumOfIntegers(a + 1, b)

    println(s"sumOfIntegers(2, 4) = ${sumOfIntegers(2, 4)}")
    println(s"sumOfIntegers(1, 3) = ${sumOfIntegers(1, 3)}")
    println(s"sumOfIntegers(sumOfIntegers(1, 2), 3) = ${sumOfIntegers(sumOfIntegers(1, 2), 3)}")

    assertAll("tests should pass",
      () => assertEquals(3, sumOfIntegers(1, 2)),
      () => assertEquals(6, sumOfIntegers(1, 3)),
      () => assertEquals(3, sumOfIntegers(sumOfIntegers(1, 2), 3)),
    )
  }
}
