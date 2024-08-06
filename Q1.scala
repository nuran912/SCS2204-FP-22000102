import scala.io.StdIn.readLine

object filterNum{
    def filterEvenNumbers(numList : List[Int]) : List[Int] =  numList.filter(_ % 2 == 0)

    def main(args : Array[String]) : Unit = {
        println("Enter a list of numbers seperated by commas : ");
        val inputNumList = readLine().split(",").map(_.trim.toInt).toList;

        println("even numbers : "+ filterEvenNumbers(inputNumList));
    }
}