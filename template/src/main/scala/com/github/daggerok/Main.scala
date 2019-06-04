package com.github.daggerok

object Hello {
  val message = "Scala Template"

  def greeting = s"Hello, ${Hello.message}!"
}

object Main extends App { // def main()
  println(Hello.greeting)
}
