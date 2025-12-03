//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File

// Import the readFileLines function from utils.kt
// If using packages, add the correct import statement

fun main() {

    val result = File("res/res-03-01").readLines().fold(0.0) { acc: Double, line ->
        acc + findHighestNumberInString(line, 12)
    }
    println("result is ${String.format("%.0f", result)}")
}
fun findHighestNumberInString(str: String, length: Int): Double {
    val baseStr = str.dropLast(length-1)
    for (num in 9 downTo 1) {
        baseStr.indexOf("$num", 0).takeIf { it >= 0 }?.let { index ->
            if (length -1 > 0) {
                val unit = findHighestNumberInString(str.substring(index + 1), length - 1)
                return "$num$unit".toDouble()
            } else {
                return num.toDouble()
            }
        }
    }
    throw RuntimeException("No int found in $str")
}