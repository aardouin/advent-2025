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
