package com.github.daggerok

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

case class Person(name: String, age: Int)

class PersonTest {
  @Test def test(): Unit = {
    val person = Person("Max", 36)
    assertAll("should assert Person",
      () => assertEquals(36, person.age),
      () => assertEquals("Max", person.name)
    )
  }
}
