//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File

// Import the readFileLines function from utils.kt
// If using packages, add the correct import statement

fun main() {
    val result = File("res/res-03-01").readLines().fold(0) { acc, line ->

        acc + findHighestNumberInString(line, true)
    }
    println("acc is $result")
}

fun findHighestNumberInString(str: String, findRight: Boolean = false): Int {
    println("Looking for number in $str")
    val baseStr = if (findRight) str.dropLast(1) else str
    for (num in 9 downTo 1) {
        baseStr.indexOf("$num", 0).takeIf { it >= 0 }?.let { index ->
            println("found $num at $index in $str")
            if (findRight) {
                val unit = findHighestNumberInString(str.substring(index + 1))
                return num * 10 + unit
            } else {
                return num
            }
        }
    }
    return 0
}