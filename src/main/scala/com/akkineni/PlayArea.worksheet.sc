import scala.util.Random
import com.akkineni.Utils
import com.akkineni.Rook
import com.akkineni.Piece
import scala.util.control.Breaks._
val state = Array.ofDim[Piece](8, 8)
// state(3)(3) = new Rook(1, 'h')

var empty = true
breakable {
  for (row <- 1 to 8) {
    val pieceFound = state(row - 1).exists(_ != null)
    println("pieceFound " + pieceFound)
    if (pieceFound) {
      empty = false
      break()
    }
  }
}
empty

val a = List(13, 17, 99, 54)
a.head
a.tail

val t = Array(1, 2, 3)
t.head
t.tail

val util = Utils(Random)
util.generate15Moves()

Array(1, 2, 3, 4, 5, 6, 7, 8).exists(i => i % 2 == 0 && i > 4)

Array(1, 2, 3, 4, 5, 6, 7).foldLeft(0)((x, y) => x + y)

val grouped = Array(1, 2, 3, 4, 5, 6, 7).groupBy(_ % 3)

val grouped5 = Array(1, 2, 3, 4, 5, 6, 7).groupBy(_ % 5)

val x = t.view.map(_ + 3).filter(_ % 3 == 0)
