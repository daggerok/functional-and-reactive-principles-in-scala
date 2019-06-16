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

  @Test def test_2(): Unit = {
    val sqrt2 = sqrt(2)
    assertAll("tests should pass",
      () => assertTrue(sqrt2 > 1.4142),
      () => assertTrue(sqrt2 < 1.4143)
    )
  }

  @Test def test_4(): Unit = {
    val sqrt4 = sqrt(4)
    assertAll("tests should pass",
      () => assertTrue(sqrt4 > 2.0000),
      () => assertTrue(sqrt4 < 2.0007)
    )
  }

  @Test def test_0_000001(): Unit = {
    val sqrt0_000001 = sqrt(1e-6)
    assertAll("tests should pass",
      () => assertTrue(sqrt0_000001 > 0.0010000001),
      () => assertTrue(sqrt0_000001 < 0.0010000002)
    )
  }

  @Test def test_1000000000000000000000000000000000000000000000000000000000000(): Unit = {
    val sqrt1000000000000000000000000000000000000000000000000000000000000 = sqrt(1e60)
    assertAll("tests should pass",
      () => assertEquals(1.0000788456669446e30, sqrt1000000000000000000000000000000000000000000000000000000000000)
    )
  }
}
