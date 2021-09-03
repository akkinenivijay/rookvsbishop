package com.zushealth.learn

import scala.annotation.tailrec

class Msg(val id: Int, val parent: Option[Int], val txt: String)

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
