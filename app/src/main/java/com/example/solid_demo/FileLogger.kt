package com.example.solid_demo

import java.io.File

/** SOLID Stands for
 * 1. Single responsibility
 * 2. Open for extension CLose for modification
 * 3. Liskov substitution - Parent class can be replaceable by its sub class
 * 4. Interface Segregation
 * 5. Dependency inversion
*/

// File logger is open for extension but close for modification (2nd Principle is following here)
open class FileLogger {
    open fun logError(error: String){
        val file = File("error.txt")
        file.appendText(text = error)
    }
}

// Custom File logger has a Single responsibility to change. (1st Principle is following here)
// 3rd Principle is also following here, because by using this class it can print the error log.
// no need to use main file logger class.
class CustomFileLogger: FileLogger() {
    override fun logError(error: String) {
        val file = File("my_custom_error.txt")
        file.appendText(text = error)
    }
}

interface FileLogger2 {
    fun printLogs()

    // This is called interface default implementation
    // By opening function body, we are not force the class to implement the function.
    // 4th Principle is following here
    fun logError(error: String){
        val file = File("error.txt")
        file.appendText(text = error)
    }
}

class CustomFileLogger2 : FileLogger2{
    override fun printLogs() {
        TODO("Not yet implemented")
    }
}