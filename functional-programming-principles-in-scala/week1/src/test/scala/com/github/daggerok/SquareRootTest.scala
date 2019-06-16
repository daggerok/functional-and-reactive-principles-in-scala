package com.github.daggerok

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class SquareRootTest {
  def abs(x: Double) = if (x < 0) -x else x

  def sqrt(x: Double): Double = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))
    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001
    def improve(guess: Double) =
      (guess + x / guess) / 2
    sqrtIter(1.0)
  }

  @Test def test(): Unit = {
    println(s"sqrt(2) = ${sqrt(2)}")

    val result = sqrt(4)
    println(s"sqrt(4) = $result")
    assertAll("tests should pass",
      () => assertTrue(result > 2.0000),
      () => assertTrue(result < 2.0007)
    )

    println(s"sqrt(1e-6) = ${sqrt(1e-6)}")
    println(s"sqrt(1e60) = ${sqrt(1e60)}")
  }
}
