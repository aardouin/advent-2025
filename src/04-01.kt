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
    val matrix = matrixFromFile("res/res-04-01")
    matrix.forEachMultiIndexed { index, item ->
        if (item == 0) return@forEachMultiIndexed

        val rangeX = max(index[0] - 1, 0)..min(index[0] + 1, matrix.shape[0] - 1)
        val rangeY = max(index[1] - 1, 0)..min(index[1] + 1, matrix.shape[1] - 1)

        if (matrix[rangeX, rangeY].sum() - 1 < 4) count++
    }

    println("result is $count")
}
