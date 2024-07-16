object Library{
    case class Book(title: String, author: String, isbn: String)

    var library: Set[Book] = Set(
        Book("GOT","George.R.R.Martin","1001"),
        Book("Dune","Frank Herbert","1002"),
        Book("'Harry Potter'","J.K.Rowling","1003")
    )
    
    def addBook(book: Book): Unit = {
        if(library.exists(_.isbn == book.isbn)){
            println("Book with isbn "+book.isbn+"already exists")
        }else{
            library += book
            println(book.title+" added to the library")
        }
    }
    def removeBook(isbn: String): Unit = {
        val bookOption = library.find(_.isbn == isbn)
        bookOption match {
            case Some(book) =>
            library -= book
            println(book.title + "removed from the library.")
            case None =>
            println("No book found with ISBN "+isbn)
        }
    }
    def isBookInLibrary(isbn: String): Boolean = {
        library.exists(_.isbn == isbn)
    }
    def searchBookByTitle(title: String): Unit = {
        val books = library.filter(_.title.equalsIgnoreCase(title))
        if (books.isEmpty) {
            println("No book found with title "+title)
        } else {
            books.foreach { book =>
            println("Found book - Title: "+ book.title + ", Author: "+book.author+", ISBN: "+book.isbn)
            }
        }
    }
    def displayBooksByAuthor(author: String): Unit = {
        val books = library.filter(_.author.equalsIgnoreCase(author))
        if (books.isEmpty) {
            println("No books found by author "+author)
        } else {
            println(s"Books by "+author+" : ")
            books.foreach { book =>
            println("Title: "+book.title+", ISBN: "+book.isbn)
            }
        }
    }
    def displayLibrary(): Unit = {
        if (library.isEmpty) {
            println("The library is empty.")
        } else {
            println("Current library collection:")
            library.foreach { book =>
                println("Title: "+book.title+", Author: "+book.author+", ISBN: "+book.isbn)
            }
        }
    }

    def main(args: Array[String]): Unit = {
        displayLibrary()
        
        println()
        addBook(Book("Animal Farm", "George Orwell", "1004"))
        println()
        displayLibrary()
        
        println()
        removeBook("1001")
        println()
        displayLibrary()
        
        println()
        searchBookByTitle("The Great Gatsby")
        
        println()
        displayBooksByAuthor("George Orwell")
  }
}