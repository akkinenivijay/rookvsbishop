package com.akkineni.learn

import org.scalatest.funsuite.AnyFunSuite

class MsgSuite extends AnyFunSuite {
  test("Recursive print of messages") {
    val result = Msg.printMessages(
      Array(
        new Msg(0, None, "Hello"),
        new Msg(1, Some(0), "World"),
        new Msg(2, None, "I am Cow"),
        new Msg(3, Some(2), "Hear me moo"),
        new Msg(4, Some(2), "Here I stand"),
        new Msg(5, Some(2), "I am Cow"),
        new Msg(6, Some(5), "Here me moo, moo")
      )
    )

    assert(result == """#0 Hello
                       |	#1 World
                       |#2 I am Cow
                       |	#3 Hear me moo
                       |	#4 Here I stand
                       |	#5 I am Cow
                       |		#6 Here me moo, moo
                       |""".stripMargin)
  }
}
