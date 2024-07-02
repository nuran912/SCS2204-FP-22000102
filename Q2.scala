def filterStrList(strings : List[String]) : List[String] = {
    strings.filter(_.length > 5)
}

def main (args : Array[String]) : Unit = {
    val sample = List("Nuran", "Dulsika", "Alwis", "is", "having", "fun")
    println(filterStrList(sample))
}
