import scala.annotation.tailrec
import scala.io.StdIn._

object KnightVsKing {

  def whoCaptures(knightPosition: Position, kingPosition: Position): String = {
    whoCaptures(Knight(knightPosition), King(kingPosition))
  }

  def whoCaptures(white: ChessPiece, black: ChessPiece): String = {
    val whiteCaptures = white.moves.contains(black.position)
    val blackCaptures = black.moves.contains(white.position)
    (whiteCaptures, blackCaptures) match {
      case (true, false)  => white.name
      case (false, true)  => black.name
      case (false, false) => "none"
      case (true, true)   => "both"
    }
  }

}