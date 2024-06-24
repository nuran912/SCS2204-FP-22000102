object area{
    def diskArea(r:Double):Double=r*r*3.14 

    def main(args: Array[String]):Unit={
        val area = diskArea(5)
        printf("%s %.2f","Area of disk:",area)
    }
}