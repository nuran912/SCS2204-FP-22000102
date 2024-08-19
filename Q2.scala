import scala.io.StdIn.readLine

object PatternMatching {
    val determineInput: Int => Unit = (n: Int) => n match {
        case x if x <= 0 => println("Negative/Zero is input");
        case x if x % 2 == 0 => println("Even number is given");
        case _ => println("Odd number is given");
    }
    
    def main(args: Array[String]): Unit = {
        print("Enter a number : ");
        val num = readLine().toInt;
        determineInput(num)
    }
}