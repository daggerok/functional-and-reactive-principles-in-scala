package com.github.daggerok

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class PatternMatchingTest {
  @Test def scala_should_have_pattern_matching(): Unit = {
    val result = "Scala" match {
      case "ololo" => true
      case "trololo" => true
      case _ => false
    }
    assertAll("should not match",
      () => assertEquals(false, result)
    )
  }
}
