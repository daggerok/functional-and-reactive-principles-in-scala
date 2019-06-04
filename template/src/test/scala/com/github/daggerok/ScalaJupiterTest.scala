package com.github.daggerok

import java.time.LocalDateTime

import org.junit.jupiter.api.{DisplayName, Test}

class ScalaJupiterTest {
  @Test @DisplayName("integration test")
  def integration_test() = println(s"Hola, ${LocalDateTime.now()}!")
}
