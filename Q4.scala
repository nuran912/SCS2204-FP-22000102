def evenSum(nums: List[Int]) : Int = {
    nums.filter(_ % 2 == 0).sum //filters the list to include only even numbers and gets their sum through the sum method
}

def main(args: Array[String]) : Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(evenSum(numbers))
}