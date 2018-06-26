package practice

import java.io.File
import java.util.*

fun main(args: Array<String>) {
    print("Enter a directory or a file: ")
    val input = Scanner(System.`in`)
    val directory = input.nextLine()
    // Display the size
    println(getSize(File(directory)).toString() + " bytes")
}

fun getSize(file: File): Long {
    var fileSize: Long = 0
    if (file.isDirectory) {
        val files = file.listFiles()
        for (f in files) {
            fileSize += getSize(f)
        }
    } else fileSize += file.length()
    return fileSize
}

