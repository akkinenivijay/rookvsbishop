import scala.annotation.tailrec
import com.akkineni.learn.Fibonnaci
import com.akkineni.learn.PascalTriangle
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

Vector.tabulate(5)(n => n * n)

val s1 = (1 +: (2 +: (3 +: (4 +: (5 +: Nil)))))
val l = (1 :: (2 :: (3 :: (4 :: (5 :: Nil)))))

val f = Fibonnaci.generate(5)

Array.ofDim[Int](2)

0 until 2

def pascal(numberOfRows: Int) = {

  val tree: Array[Array[Int]] =
    Array.tabulate(numberOfRows)(n => Array.ofDim[Int](n + 1))
  tree(0)(0) = 1

  @tailrec
  def loop(iter: Int): Array[Array[Int]] = {
    if (iter != numberOfRows) {
      println("Iter: " + iter)
      println("Length: " + tree(iter).length)
      for (col <- 0 until tree(iter).length) {
        if (col == 0 || col == tree(iter).length - 1)
          tree(iter)(col) = 1
        else {
          tree(iter)(col) = tree(iter - 1)(col - 1) + tree(iter - 1)(col)
        }
      }
      loop(iter + 1)
    } else {
      tree
    }
  }
  loop(1)
}

val result = pascal(5)

PascalTriangle.print(4)
