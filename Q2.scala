import scala.io.StdIn.readLine

object SquareCal{
    def calculateSqr(numList : List[Int]): List[Int] = numList.map(num => num * num);

    def main(args: Array[String]): Unit = {
        println("Enter a list of numbers seperated by commas : ");
        val inputNumList = readLine().split(",").map(_.trim.toInt).toList;

        println("square numbers : "+ calculateSqr(inputNumList));
    }
}