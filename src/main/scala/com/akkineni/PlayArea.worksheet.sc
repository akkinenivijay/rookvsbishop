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
