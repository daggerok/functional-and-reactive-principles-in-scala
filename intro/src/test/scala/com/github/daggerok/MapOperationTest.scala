package com.github.daggerok

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class MapOperationTest {
  @Test def scala_should_concat_map_entries(): Unit = {
    val empty = Map.empty
    val sigle = Map.empty +
      (2001 -> "Scala first design")
    val multi = Map.empty +
      (2003 -> "Scala first version") ++
      (2004 to 2014).map(_ -> "Journey...")
    val reactive = Map.empty +
      (2003 -> "Scala first version") ++
      (2004 to 2014).map(_ -> "Journey...") + //
      (2015 -> "Reactive!")
    assertAll("should not match",
      () => assertTrue(empty.isEmpty),
      () => assertEquals(1, sigle.size),
      () => assertEquals(12, multi.size),
      () => assertEquals(13, reactive.size)
    )
  }
}
