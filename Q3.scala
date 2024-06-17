object sphere{
    def volume(r: Double) = 4/3*3.14*r*r*r

    def main(args: Array[String]):Unit={
        val vol = volume(5)
        printf("%s %.2f", "Volume of the sphere is: ", vol)
    }
}