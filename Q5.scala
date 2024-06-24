object time{
    def easy(d: Int) = d*8
    def tempo(d: Int) = d*7

    def main(args: Array[String]):Unit={
        val total = easy(2)+tempo(3)+easy(2)
        printf("%s %d%s", "Total running time:",total,"min")
    }
}