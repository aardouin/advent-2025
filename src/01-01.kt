//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File
import java.io.IOException
import kotlin.compareTo
import kotlin.rem

// Import the readFileLines function from utils.kt
// If using packages, add the correct import statement

fun main() {
    val regex = Regex("^([LR])(\\d+)")

    var position = 50
    var zeroHits = 0
    readFileLines("res/res-01-01") { line ->
        val match = regex.find(line) ?: throw RuntimeException("The instructions are misleading ! : $line")
        val (direction, number) = match.destructured
        //Don't turn the wheel more than 100 steps ! this doenns't make sens
        val rotation = number.toInt() % 100
        position += if (direction == "L") -rotation else rotation
        // answer should be in  -99..199, make it 0..99
        position = (position + 100) % 100
        println("Direction: $direction, Number: $number, Now pointing at: $position")
        // Jut to make sure we are in bounds
        if (position !in 0..99) throw RuntimeException("Out of bounds ! Position: $position")
        if (position == 0) println("Zero hit count: ${++zeroHits}")
    }
    println("The password should be : $zeroHits")
}