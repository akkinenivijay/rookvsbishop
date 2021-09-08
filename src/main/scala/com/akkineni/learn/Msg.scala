package com.akkineni.learn

import scala.annotation.tailrec

class Msg(val id: Int, val parent: Option[Int], val txt: String)

/** Write a recursive method printMessages that can receive an array of Msg
  * class instances, each with an optional parent ID, and use it to print out a
  * threaded fashion. That means that child messages are print out indented
  * underneath their parents, and the nesting can be arbitrarily deep
  */
object Msg {

  def printMessages(messages: Array[Msg]): String = {

    @tailrec
    def loop(msg: Msg, printString: String): String = {
      msg.parent match {
        case None => printString
        case Some(parent) =>
          loop(messages(parent), printString = "\t" + printString)
      }
    }

    messages.foldLeft("")((accumulator, msg) =>
      accumulator + loop(msg, printString = "#" + msg.id + " " + msg.txt + "\n")
    )
  }
}
