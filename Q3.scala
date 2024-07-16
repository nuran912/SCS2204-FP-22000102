object Fibonacci {

    def printFibonacci(n: Int): Unit = {
        def fib(a: Int, b: Int, count: Int): Unit = {
            if (count > 0) {
                print(a + " ")
                fib(b, a + b, count - 1)
            }
        }
        fib(0, 1, n)
    }
    
    def main(args: Array[String]): Unit = {
    printFibonacci(10)
    }
}