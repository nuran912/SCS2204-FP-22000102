class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  private val gcdValue: Int = gcd(n.abs, d.abs)
  var numerator: Int = n / gcdValue
  var denominator: Int = d / gcdValue

  def this(n: Int) = this(n, 1)

  if (denominator < 0) {
    numerator = -numerator
    denominator = -denominator
  }

  // Method to get the negated rational number
  def neg: Rational = new Rational(-numerator, denominator)

  // Override toString to display the rational number
  override def toString: String =
    if (denominator == 1) s"$numerator" else s"$numerator/$denominator"

  // Helper method to calculate GCD
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  // Method to subtract another Rational
  def sub(value: Rational): Rational = {
    new Rational(
      this.numerator * value.denominator - value.numerator * this.denominator,
      this.denominator * value.denominator
    )
  }

  // Method to add another Rational
  def add(value: Rational): Rational = {
    new Rational(
      this.numerator * value.denominator + value.numerator * this.denominator,
      this.denominator * value.denominator
    )
  }
}

object RationalApp {
  def main(args: Array[String]): Unit = {
    println("Enter a rational number to negate (format: numerator/denominator): ")
    val input = scala.io.StdIn.readLine().split("/")

    if (input.length == 2) {
      val rational = new Rational(input(0).toInt, input(1).toInt)
      println(s"Negation of $rational is: ${rational.neg}")
    } else {
      println("Invalid input format")
    }

    println("To find x-y-z, enter the values (format: numerator/denominator): ")

    def getRationalInput(prompt: String): Rational = {
      print(prompt)
      val in = scala.io.StdIn.readLine().split("/")
      if (in.length == 2) new Rational(in(0).toInt, in(1).toInt)
      else {
        println("Invalid input format. Defaulting to 0/1.")
        new Rational(0, 1)
      }
    }

    val x = getRationalInput("Enter x: ")
    val y = getRationalInput("Enter y: ")
    val z = getRationalInput("Enter z: ")

    val result = x.sub(y).sub(z)
    println(s"x-y-z is: $result")
  }
}
