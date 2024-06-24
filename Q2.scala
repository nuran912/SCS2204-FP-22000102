object variables{
    var a : Int = 2
    var b : Int = 3
    var c : Int = 4
    var d : Int = 5
    var k : Float = 4.3f

    def main (args : Array[String]) : Unit = {
        b+=1
        println("a) --b * a + c * d-- : " + (b * a + c * d))
        d-=1
        println("b) a++ : " + a)
        a+=1
        //println("c) -2 * (g - k) + c : " + (-2 * (g - k) + c))
        println("d) c = c++ : " + c)
        c+=1 
        c+=1
        println("e) c = ++c * a++ : " + (c * a))
    }
}