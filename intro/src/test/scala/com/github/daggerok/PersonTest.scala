package com.github.daggerok

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

case class Person(name: String, age: Int)

class PersonTest {

  @Test def scala_should_have_case_classes(): Unit = {
    val person = Person("Max", 36)

    assertAll("should use case class",
      () => assertEquals(36, person.age),
      () => assertEquals("Max", person.name)
    )
  }

  @Test def scala_should_have_decomposition_infix_partition_and_clojure_functional_argument(): Unit = {
    val people = Array(
      Person("Max", 36),
      Person("Maksim", 26),
      Person("Maksinmko", 16)
    )
    val (adults, minors) = people partition (_.age > 18)

    assertAll("should use functional principles",
      () => assertEquals(1, minors.length),
      () => assertEquals(2, adults.length)
    )
  }

  @Test def scala_should_easy_parallelize_just_with_par(): Unit = {
    val people: Array[Person] = Array(
      Person("Max", 36),
      Person("Maksim", 26),
      Person("Maksinmko", 16)
    )
    val (minors, adults) = people.par partition (_.age < 18)

    assertAll("should parallelize",
      () => assertTrue(1 == minors.length),
      () => assertEquals(2, adults.length)
    )
  }
}
