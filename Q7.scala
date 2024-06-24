def bookPrice(x:Int):Double = x*24.95
def discount(amount:Double):Double = amount * 0.4
def shippingCost(x:Int):Double = {
    if (x>50) x*3+(x-50)*0.75
    else x*3
}

def main(args:Array[String]):Unit = {
    printf("Total wholesale cost for 60 books is %.3f\n", bookPrice(60) - discount(bookPrice(60)) + shippingCost(60))
}