
import org.scalatest.mock.MockitoSugar

import org.scalatest.BeforeAndAfter
import org.junit.runner.RunWith
import org.scalatest.OneInstancePerTest
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.junit.JUnitRunner
import math._

@RunWith(classOf[JUnitRunner])
class KnightVsKingSpec extends FlatSpec with Matchers with MockitoSugar with OneInstancePerTest with BeforeAndAfter {

  "a king" should "list correctly its moves in the corner" in {
    King(Position('a', 1)).moves shouldBe Set(Position('a', 2), Position('b', 1), Position('b', 2))
    King(Position('h', 1)).moves shouldBe Set(Position('h', 2), Position('g', 1), Position('g', 2))
  }

  "a position" should "implement an addition" in {
    Position('a', 1) + Direction(1, 1) shouldBe Position('b', 2)
  }
  
  "a knight" should "list correctly its moves in the corner" in {
    Knight(Position('a', 1)).moves shouldBe Set(Position('c', 2), Position('b', 3))
    Knight(Position('h', 1)).moves shouldBe Set(Position('g', 3), Position('f', 2))
  }
  
  "a chess board" should "answer who can capture" in {
    KnightVsKing.whoCaptures(Position('c', 4), Position('d', 6)) shouldBe "knight"
    KnightVsKing.whoCaptures(Position('b', 7), Position('c', 6)) shouldBe "king"
    KnightVsKing.whoCaptures(Position('f', 2), Position('b', 6)) shouldBe "none"
  }
}