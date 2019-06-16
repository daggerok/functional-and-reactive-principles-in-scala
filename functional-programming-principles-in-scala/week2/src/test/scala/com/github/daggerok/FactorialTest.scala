package com.github.daggerok

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class FactorialTest {
  @Test def test_classic_algorithm(): Unit = {
    def factorial(n: Int): Int =
      if (n == 0) 1 else n * factorial(n - 1)

    println(s"factorial(0) = ${factorial(0)}")
    println(s"factorial(1) = ${factorial(1)}")
    println(s"factorial(2) = ${factorial(2)}")
    println(s"factorial(3) = ${factorial(3)}")
    println(s"factorial(4) = ${factorial(4)}")
    println(s"factorial(5) = ${factorial(5)}")

    assertAll("tests should pass",
      () => assertEquals(1, factorial(0)),
      () => assertEquals(1, factorial(1)),
      () => assertEquals(2, factorial(2)),
      () => assertEquals(6, factorial(3)),
      () => assertEquals(24, factorial(4)),
      () => assertEquals(120, factorial(5)),
    )
  }
}
