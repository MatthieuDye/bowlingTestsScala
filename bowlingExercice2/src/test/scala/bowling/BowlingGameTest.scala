package bowling

import org.scalatest._

class BowlingGameTest extends FunSpec with Matchers with GivenWhenThen with BeforeAndAfter {


  describe("If you roll only once the ball") {
    describe("and you knock down one pin") {
      it("you should have 1 point (One Ball One Pin).") {
        var oneBallOnePin = new Game()
        oneBallOnePin.roll(1)
        assert(1 === oneBallOnePin.score())
      }
    }

    describe("and you never knock down a pin") {
      it("you should have 0 point (One Ball No Pin).") {
        var oneBallNoPin = new Game()
        oneBallNoPin.roll(0)
        assert(0 === oneBallNoPin.score())
      }
    }
  }

  describe("During a game, if you lanch 20 times the roll") {
    describe("Missing all pins (gutter game)") {
      it("gives no points (All Balls No Pin)") {
        var gutterGame = new Game()
        gutterGame.rollMany(20, 0)
        assert(0 === gutterGame.score())
      }
    }

    describe("Knocking down ONE pin each time") {
      it("gives you 20 points (All Balls Twenty Points)") {
        var allBallsTwentyPoints = new Game()
        allBallsTwentyPoints.rollMany(20, 1)
        assert(20 === allBallsTwentyPoints.score())
      }
    }
  }

 describe("Test One spare") {
   it("You should have a bonus") {
     var newGame = new Game()
     newGame.rollSpare()
     newGame.roll(3)
     newGame.rollMany(17, 0)
     assert(16 === newGame.score())
   }
 }

  describe("Test One STRIKE") {
    it("You should have a bonus") {
      var strikeGame = new Game()
      strikeGame.rollStrike()
      strikeGame.roll(3)
      strikeGame.roll(4)
      strikeGame.rollMany(16, 0)
      assert(24 === strikeGame.score())
    }
  }

  describe("Test PERFECT GAME") {
    it("AROUND 300 POINTS") {
      var perfectGame = new Game()
      perfectGame.rollMany(12,10)
      assert(300 === perfectGame.score())
    }
  }




}