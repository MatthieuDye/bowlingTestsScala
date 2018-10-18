package bowling

import scala.List

case class Game() {

  private var _rollsList = Array.fill(21)(0) //newRollList
  private var _currentRoll = 0 //newRoll


  def roll(pins: Int): Unit = {
    _currentRoll = _currentRoll + 1
    _rollsList(_currentRoll) = pins

  }

  def rollsList(): Array[Int] = _rollsList

  def rollMany(n: Int, pins: Int) = {
    for (i <- 0 until n) {
      roll(pins)
    }
  }

  def score(): Int = {
    var score = 0
    var frameIndex = 1

    for (frame <- 0 until 10) { // number of games : from 1 to 20 (without counting the 0 with the roll method trick
      if (isStrike(frameIndex)) // strike
      {
        score += 10 + strikeBonus(frameIndex)
        frameIndex += 1
      }
      else if (isSpare(frameIndex)) //spare
      {
        score += 10 + spareBonus(frameIndex)
        frameIndex += 2
      } else {
        score += sumOfBallsInFrame(frameIndex)
        frameIndex += 2
      }
    }

    score
  }

  def isStrike(frameIndex: Int) : Boolean = {
    return rollsList()(frameIndex) == 10
  }

  def rollList(): Array[Int] = _rollsList

  def currentRoll(): Int = _currentRoll

  def isSpare(frameIndex: Int): Boolean = {
    rollsList()(frameIndex) + rollsList()(frameIndex + 1) == 10
  }

  def rollSpare(): Unit = {
    roll(5)
    roll(5)
  }

  def rollStrike() :Unit = {
    roll(10)
  }

  def sumOfBallsInFrame(frameIndex: Int): Int = {
    return rollsList()(frameIndex) + rollsList()(frameIndex+1)
  }

  def spareBonus(frameIndex: Int): Int = {
    return rollsList()(frameIndex+2)
  }

  def strikeBonus(frameIndex: Int): Int = {
    return rollsList()(frameIndex+1) + rollsList()(frameIndex+2)
  }
}
