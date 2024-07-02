def reverseStr(str: String): String = {
    if(str.isEmpty){   ""  }
    else{
        reverseStr(str.tail) + str.head
        //str.head returns the first character of the string
        //str.tail returns the characters except the first character
    }
}

def main (args: Array[String]): Unit = {
    println(reverseStr("Hello"))
    println(reverseStr("Bye"))

    val str1 = "Hello"
    println(str1.head)
    println(str1.tail)

}