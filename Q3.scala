object Company{
    def salary(n: Int, ot: Int) = (n*250 + ot*85)*0.88

    def main(args : Array[String]) : Unit = {
        println("take home salary of the employee per week: " + salary(40, 30) + "LKR")
    }
}