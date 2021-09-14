fun main(args: Array<String>) {
 var menyval = 0
 val library = mutableListOf<Book>()
 library.add(Book("Emil", "Astrid", 1955, 1992, true, 1))
 library.add(Book("Sune", "Anders", 1995, 1998, true, 2))
 library.add(Book("Röda rummet", "August", 1892, 1985, true, 3))
 println(library.random())
 var booknr = 3
 while (menyval != 5) {
  println("1. Add a book to the library")
  println("2. Search for a book by name")
  println("3. List all available books")
  println("4. Return a book")
  println("5. Quit")
  menyval = (readLine() ?: "").toInt()
  if (menyval == 5) {
   break
  }
  if (menyval == 1) {
   booknr += 1
   println("Title:")
   var title = readLine()
   println("Author:")
   var author = readLine()
   println("Publishing Year:")
   var year = (readLine() ?: "").toInt()
   println("Edition:")
   var edition = (readLine() ?: "").toInt()
   library.add(Book("$title", "$author", year, edition, true, booknr))

  }
  if (menyval == 2) {
   println("Write the title of the book and hit enter:")
   var name = readLine() ?: ""
   for (i in library) {
    if (i.findTitle(name)) {
     println(i)
    }
   }
   var index = 0
   for (i in library) {
    index += 1
    if (i.findTitle(name)) {
     break
    } else if (index == library.size) {
     println("Our library has no copy of that book.")
    }
   }
   println("Write the booknumber of the book you want to loan. Hit n if you don't want to loan any of the listed books.")
   var nr = readLine() ?: ""
   var booknr = nr.toInt()
   for (i in library) {
    if (nr == "n") {
     break
    }
    if (i.findBooknr(booknr)) {
     var available = i.loan()
     if (available) {
      println("Thank you for using our service!")
      break
     }
     if (!available) {
      println("That book is not available.")
     } else {
      break
     }
    }
   }
  }

   if (menyval == 3) {
    for (i in library) {
     if (i.findAvailable()) {
      println(i)
     }
    }
    var index = 0
    for (i in library) {
     index += 1
     if (i.findAvailable()) {
      break
     }
     else if (index == library.size) {
      println("No books are available at the moment.")
     }

    }
   }
   if (menyval == 4) {
    println("Write the title of the book you are returning:")
    var bookTitle = readLine() ?: ""
    var index = 0
    for (i in library) {
     index += 1
     if (i.findTitle(bookTitle)) {
      var bookReturn = i.returnBook()
      if (bookReturn) {
       println("Thank you for your return!")
       break
      }
      if (!bookReturn) {
       println("Error! That book is not loaned.")
       break
      }
     } else if (index == library.size) {
      println("This book doesn't belong to our library")
      break
     }

    }
   }
  }
 }

  /* var Emil = Book("Emil", "Astrid", 1955, 1992   )

    var b = Emil.loan()
    println(b)
    b = Emil.returnBook()
    println(b)
    println(Emil)

   */
