package com.github.daggerok

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class GreatestCommonDividerTest {
  @Test def test_Euclid_algorithm(): Unit = {
    def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)

    println(s"gcd(2, 4) = ${gcd(2, 4)}")
    println(s"gcd(3, 6) = ${gcd(3, 6)}")
    println(s"gcd(14, 21) = ${gcd(14, 21)}")

    assertAll("tests should pass",
      () => assertEquals(2, gcd(2, 4)),
      () => assertEquals(3, gcd(3, 6)),
      () => assertEquals(7, gcd(14, 21))
    )
  }
}
