object converter{
    def c2f(c: Double) = c*1.8+32

    def main(args: Array[String]):Unit={
        val temp = c2f(35)
        printf("%s %.2f","35C in Farenheit is: ",temp)
    }
}