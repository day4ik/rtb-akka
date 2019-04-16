package com.rtb

import akka.actor.{ Actor, Props }

class Member(money: BigDecimal) extends Actor {
  override def receive: Receive = ???
}

object Member {

  // current auction slot
  case class Slot(value: String, minValue: BigDecimal)

  // response to sender if can participate
  case class Bid(value: BigDecimal)

  case class BidWon()

  def props(money: BigDecimal) = Props(new Member(money))
}