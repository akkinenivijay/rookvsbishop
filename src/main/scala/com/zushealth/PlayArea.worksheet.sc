import com.zushealth.Utils
import com.zushealth.Game
1 + 2

'a' - 'b'

val game = new Game(new Utils())
val endResult: String = game.play()

def testMethod(func: Int => Int, input: Int): Int = {
  func(input)
}

val square: Int => Int = i => i + i

testMethod(square, 2)

testMethod(i => (i + i), 2)

def increment(i: Int) = {
  i + 1
}

testMethod(increment, 7)

testMethod(_ + 5, 8)
