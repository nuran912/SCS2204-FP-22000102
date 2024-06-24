object area {
    def diskArea(x:Double):Double=x*x*math.Pi

    def main(args: Array[String]):Unit={
        val area = diskArea(5)
        printf("%.2f", area)
    }
}