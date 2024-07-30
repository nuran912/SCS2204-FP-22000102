import scala.io.StdIn.readLine

object StudentRecords extends App {

  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    println("Enter student's name:")
    val name = readLine()
    
    println("Enter student's marks:")
    val marks = readLine().toInt
    
    println("Enter total possible marks:")
    val totalMarks = readLine().toInt

    val percentage = (marks.toDouble / totalMarks) * 100

    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }

    (name, marks, totalMarks, percentage, grade)
  }

  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Student Name: $name")
    println(s"Marks: $marks")
    println(s"Total Possible Marks: $totalMarks")
    println(s"Percentage: $percentage%")
    println(s"Grade: $grade")
  }

  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty."))
    } else if (marks < 0 || marks > totalMarks) {
      (false, Some("Marks should be positive and not exceed total possible marks."))
    } else {
      (true, None)
    }
  }

  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var valid = false
    var record: (String, Int, Int, Double, Char) = ("", 0, 0, 0.0, 'F')

    while (!valid) {
      println("Enter student's name:")
      val name = readLine()
      
      println("Enter student's marks:")
      val marks = readLine().toInt
      
      println("Enter total possible marks:")
      val totalMarks = readLine().toInt

      val (isValid, errorMessage) = validateInput(name, marks, totalMarks)
      if (isValid) {
        valid = true
        val percentage = (marks.toDouble / totalMarks) * 100
        val grade = percentage match {
          case p if p >= 90 => 'A'
          case p if p >= 75 => 'B'
          case p if p >= 50 => 'C'
          case _ => 'D'
        }
        record = (name, marks, totalMarks, percentage, grade)
      } else {
        println(errorMessage.getOrElse("Invalid input. Please try again."))
      }
    }

    record
  }

  val studentRecord = getStudentInfoWithRetry()
  printStudentRecord(studentRecord)
}
