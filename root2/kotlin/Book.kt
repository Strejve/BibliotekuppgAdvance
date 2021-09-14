class Book (var Title:String, var Author:String, var Year:Int, var Edition:Int, var Status:Boolean = true,) {
    fun loan(): Boolean {
        if (Status == true) {
            Status = false
            return true
        }
        return false
    }

    fun returnBook(): Boolean {
        if (Status == false) {
            Status = true
            return true
        }
        return false
    }

    override fun toString(): String {
        var a = "Available"
        if (Status == true) {
            var a = "Available"
        } else {
            a = "Unavailable"
        }
        return "$Title, $Author, $Year, Edition: $Edition, Status : $a"
    }

    fun findTitle(search: String): Boolean {
        if (search == Title) {
            return true
        }
        return false
    }

    fun findAvailable(): Boolean {
        if (true == Status) {
            return true
        }
        return false
    }
}