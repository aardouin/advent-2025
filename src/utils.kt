import org.jetbrains.kotlinx.multik.api.mk
import org.jetbrains.kotlinx.multik.api.ndarray
import org.jetbrains.kotlinx.multik.ndarray.data.D2
import org.jetbrains.kotlinx.multik.ndarray.data.MutableMultiArray
import java.io.File
import java.io.IOException

/**
 * Reads a text file line by line and calls the provided closure for each line.
 * @param filePath The path to the text file.
 * @param onLine The closure to call for each line.
 */
fun readFileLines(filePath: String, onLine: (String) -> Unit) {
    try {
        File(filePath).forEachLine { line ->
            onLine(line)
        }
    } catch (e: IOException) {
        println("Error reading file: ${e.message}")
    }
}


fun matrixFromFile(path: String): MutableMultiArray<Int, D2> {
    val lines = File(path).readLines()
    val data = lines.map { line ->
        line.map { if (it == '@') 1 else 0 }
    }
    return mk.ndarray(data)
}