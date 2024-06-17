object store{
    def cp(n: Double) = 24.95*0.6*n
    def sc(n: Double) = {
        if(n>50) 50*3 + (n-50)*0.75
        else n*3
    }
    def total(n: Double) = cp(n)+sc(n)

    def main(args: Array[String]):Unit={
        printf("%s %.2f", "Total wholesale cost: ",total(60))
    }
}