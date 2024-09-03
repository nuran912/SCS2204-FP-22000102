def countLetterOccurrences(words: List[String]): Int = {
  val len = words.map(_.length)  // Map each word to its length
  len.sum                        // Return the sum of the lengths
}

def main(args: Array[String]): Unit = {
  println(s"list of words(seperated by comma): ")
  val input = scala.io.StdIn.readLine().split(",").toList.map(_.trim) 
  print(input)
  println(s"Number of letters in the sentence: ${countLetterOccurrences(input)}")
}
