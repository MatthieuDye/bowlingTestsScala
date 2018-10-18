package bowling

case class Frame() {

  var rollList = List.fill(2)(Roll)


  def score() : Int = {
    var sum = 0
    rollList.foreach(roll => sum = sum + 0)
    sum
  }
}

