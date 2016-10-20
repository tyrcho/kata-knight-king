import scala.annotation.tailrec
import scala.io.StdIn._

object KnightVsKing {

  def whoCaptures(knightPosition: Position, kingPosition: Position): String = {
    if (Knight(knightPosition).moves.contains(kingPosition)) "knight"
    else if (King(kingPosition).moves.contains(knightPosition)) "king"
    else "none"
  }

}