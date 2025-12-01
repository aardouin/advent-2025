//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File
import java.io.IOException
import kotlin.compareTo
import kotlin.math.abs
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
        val rawRotation = number.toInt()
        //count all full rotation
        val hitCount = rawRotation / 100
        zeroHits += hitCount

        val startAtZero = position == 0

        // remaining rotations
        val rotation = rawRotation % 100
        position += if (direction == "L") -rotation else rotation
        if (position !in 0..100 && !startAtZero) {
            zeroHits++
        }
        position = (position + 100) % 100
        if (position == 0) println("Zero hit ${++zeroHits}")
    }
    println("The password should be : $zeroHits")
}