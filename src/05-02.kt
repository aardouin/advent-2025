import java.io.File

fun main() {
    val count = File("res/res-05-01-ranges").readLines().map {
        val (start, end) = it.split("-").map(String::toLong)
        LongRange(start, end)
    }.merge().fold(0.0) { acc, range ->
        acc + range.last - range.first + 1
    }
    println("result is ${String.format("%.0f", count)}")
}