package com.github.daggerok

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class HigherOrderFunctionsTest {
  @Test def test_higher_order_functions(): Unit = {
    def identity(x: Int) = x
    def double(x: Int) = x * x
    def cube(x: Int) = x * x * x

    def sum(f: Int => Int, a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sum(f, a + 1, b)

    assertAll("tests should pass",
      () => assertEquals(3, sum(identity, 1, 2), "1 + 2 == 3"),
      () => assertEquals(6, sum(identity, 1, 3), "1 + 2 + 3 == 6"),
      () => assertEquals(5, sum(double, 1, 2), "1*2 + 2*2 == 1 + 4 == 5"),
      () => assertEquals(14, sum(double, 1, 3), "1*1 + 2*2 + 3*3 == 1 + 4 + 9 == 14"),
      () => assertEquals(9, sum(cube, 1, 2), "1*1*1 + 2*2*2 == 1 + 8 == 9"),
      () => assertEquals(36, sum(cube, 1, 3), "1*1*1 + 2*2*2 + 3*3*3 == 1 + 8 + 27 == 36"),
    )
  }

  @Test def test_sumOfDoubles_higher_order_functions(): Unit = {
    def sum(f: Int => Int, a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sum(f, a + 1, b)

    def double(x: Int) = x * x

    println(s"sum(double, 1, 1) = ${sum(double, 1, 1)}")
    println(s"sum(double, 2, 2) = ${sum(double, 2, 2)}")
    println(s"sum(double, 3, 3) = ${sum(double, 3, 3)}")
    println(s"sum(double, 2, 3) = ${sum(double, 2, 3)}")
    println(s"sum(double, 1, 3) = ${sum(double, 1, 3)}")

    assertAll("tests should pass",
      () => assertEquals(1, sum(double, 1, 1)),
      () => assertEquals(4, sum(double, 2, 2)),
      () => assertEquals(5, sum(double, 1, 2)),
      () => assertEquals(9, sum(double, 3, 3)),
      () => assertEquals(13, sum(double, 2, 3)),
      () => assertEquals(14, sum(double, 1, 3)),
    )
  }

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
