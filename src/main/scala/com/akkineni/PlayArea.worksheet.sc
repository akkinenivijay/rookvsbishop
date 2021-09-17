import com.akkineni.learn.Factorial
import com.akkineni.learn.PascalTriangle
import scala.language.postfixOps

val result = PascalTriangle.generate(2)

val l = PascalTriangle.generate(2) sameElements Array(Array(1), Array(1, 1))

Factorial.compute(10)

5 % 2

class Person(val name: String, val favoriteMovie: String, val age: Int) {
  def likes(movie: String): Boolean = movie == favoriteMovie
  def +(person: Person): String =
    s"${this.name} hangsOut with ${person.name} "

  def +(nickName: String): Person =
    new Person(name + "(" + nickName + ")", favoriteMovie, age)
  def unary_! : String = s"$name, what the heck"

  def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
  def isAlive: Boolean = true
  def apply(): String = s"Hi, My Name is $name"

  def learns(str: String): String = s"$name learns $str"

  def learnsScala: String = this learns "Scala"

  def apply(num: Int) = s"$name watched her $favoriteMovie $num times"
}

val mary = new Person("Mary", "Inception", 36)
mary likes "Inception"

val tom = new Person("Tom", "Fight Club", 30)

mary + "The Rockstar"

!mary

mary()

mary isAlive

+mary

mary learns "Scala"

mary learnsScala

mary(2)
