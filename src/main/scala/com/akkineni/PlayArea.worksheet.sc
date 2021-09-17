import com.akkineni.learn.Factorial
import com.akkineni.learn.PascalTriangle

val result = PascalTriangle.generate(2)

Factorial.compute(10)

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

abstract class Animal {
  val creatureType: String
  def eat: Unit
}

class Dog extends Animal {

  override val creatureType: String = "canine"

  override def eat: Unit = println("crunch crunch")

}

trait Carnivore {
  def eat(animal: Animal): Unit
}
