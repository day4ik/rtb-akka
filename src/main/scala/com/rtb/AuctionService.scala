package com.rtb

import akka.actor.{ Actor, ActorRef, Props }

import scala.util.Random

class AuctionService extends Actor {
  override def receive: Receive = ???

  private def choose(participants: Seq[(String, BigDecimal)]): Option[String] = {
    if (participants.isEmpty)
      None
    else
      participants.sortBy(_._2).takeRight(10).lift(Random.nextInt(10)).map(_._1)
  }
}

object AuctionService {
  // add member to participate in auction
  case class AddMember(id: String, actorRef: ActorRef)

  // start auction
  // should response with winner by 20 ms
  // use method 'choose' to find winner from bids
  // ignore all members who didn't response with time interval
  case class Auction(slot: String, minValue: BigDecimal)

  // winner of auction
  case class Winner(id: String)

  // if no one respond with bid
  case class NoBidsFound()

  def props = Props(new AuctionService)
}