import org.jetbrains.kotlinx.multik.api.*
import org.jetbrains.kotlinx.multik.ndarray.data.D2
import org.jetbrains.kotlinx.multik.ndarray.data.MultiArray
import org.jetbrains.kotlinx.multik.ndarray.data.MutableMultiArray
import org.jetbrains.kotlinx.multik.ndarray.data.get
import org.jetbrains.kotlinx.multik.ndarray.data.set
import org.jetbrains.kotlinx.multik.ndarray.operations.*
import java.io.File
import kotlin.collections.map
import kotlin.math.max
import kotlin.math.min
import kotlin.text.map

fun main() {

    var count = 0
    val ranges = File("res/res-05-01-ranges").readLines().map {
        val (start, end) = it.split("-").map(String::toLong)
        LongRange(start, end)
    }.merge()

    val lines = File("res/res-05-01-list").readLines().filter {
        ranges.any { r ->
            r.contains(it.toLong())
        }
    }

    println("result is ${lines.count()}")

}
fun List<LongRange>.merge(): List<LongRange> {
    if (this.isEmpty()) return emptyList()
    val sorted = this.sortedBy { it.first }
    val merged = mutableListOf<LongRange>()
    var currentRange = sorted.first()
    for (i in 1 until sorted.size) {
        val nextRange = sorted[i]
        if (nextRange.first <= currentRange.last + 1) {
            currentRange = currentRange.first..maxOf(currentRange.last, nextRange.last)
        } else {
            merged.add(currentRange)
            currentRange = nextRange
        }
    }
    merged.add(currentRange)
    return merged
}