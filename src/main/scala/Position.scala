

case class Position(column: Char, row: Int) {

  val isValid =
    column <= 'h' &&
      column >= 'a' &&
      row >= 1 &&
      row <= 8

  def +(d: Direction) = Position((column + d.col).toChar, row + d.row)
}

case class Direction(col: Int, row: Int)

trait ChessPiece {
  def directions: Iterable[Direction]
  val name: String
  val position: Position

  def moves: Set[Position] = {
    directions.map { x => position + x }.filter { x => x.isValid }.toSet
  }
}

case class King(position: Position) extends ChessPiece {
  val directions = for {
    c <- -1 to 1
    r <- -1 to 1
    if r != 0 || c != 0
  } yield Direction(r, c)

  val name = "king"
}

case class Rook(position: Position) extends ChessPiece {
  val directions = for {
    c <- -8 to 8
    r <- -8 to 8
    if (r == 0 || c == 0) && c != r
  } yield Direction(r, c)

  val name = "rook"
}

case class Bishop(position: Position) extends ChessPiece {
  val directions = for {
    c <- -8 to 8
    r <- -8 to 8
    if c.abs == r.abs && c != 0
  } yield Direction(r, c)

  val name = "bishop"
}

case class Pawn(position: Position, white : Boolean) extends ChessPiece {
  val directions = if (white) Set(Direction(1, 1), Direction (-1, 1) )
                   else Set(Direction(1, -1), Direction (-1, -1) )

  val name = "bishop"
}

case class Knight(position: Position) extends ChessPiece {
  val directions = Set(Direction(-1, -2),
    Direction(-1, 2),
    Direction(1, -2),
    Direction(1, 2),
    Direction(-2, -1),
    Direction(-2, 1),
    Direction(2, -1),
    Direction(2, 1))

  val name = "knight"
}