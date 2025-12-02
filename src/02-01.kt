import java.io.File

fun main() {
    val regexInvalidIds = Regex("""(\d+)\1""")
    val input = File("res/res-02-01").readLines().first()
    val results = mutableListOf<Long>()

    val ranges = input.split(",")
    for (range in ranges) {
        val (start, end) = range.split("-").map { it.toLong() }
        for (i in start..end) {
            if (i.toString().matches(regexInvalidIds)) {
                println("$i is invalid")
                results.add(i)
            }
        }
    }
    println("result is = ${results.sum()}")
}