import org.jetbrains.kotlinx.multik.ndarray.data.get
import org.jetbrains.kotlinx.multik.ndarray.data.set
import org.jetbrains.kotlinx.multik.ndarray.operations.forEachMultiIndexed
import org.jetbrains.kotlinx.multik.ndarray.operations.sum
import kotlin.math.max
import kotlin.math.min

fun main() {


    var count = 0
    val matrix = matrixFromFile("res/res-04-01")

    var oldCount = -1
    while(oldCount != count) {
        oldCount = count
        matrix.forEachMultiIndexed { index, item ->
            if (item == 0) return@forEachMultiIndexed

            val rangeX = max(index[0] - 1, 0)..min(index[0] + 1, matrix.shape[0] - 1)
            val rangeY = max(index[1] - 1, 0)..min(index[1] + 1, matrix.shape[1] - 1)
            val sumNeighbor = matrix[rangeX, rangeY].sum() - 1
            if (sumNeighbor < 4) {
                count++
                matrix[index[0], index[1]] = 0
            }
        }
    }

    println("result is $count")
}