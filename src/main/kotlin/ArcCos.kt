import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow

object ArcCos {
    private const val esp = 1e-10

    fun calc(x: Double): Double {
        if (abs(x) > 1)
            return Double.NaN

        var result: Double = PI / 2.0
        var n = 1.0
        var topFact = 1.0
        var botFact = 1.0
        var newResult: Double = PI / 2 - x

        while (abs(result - newResult) > esp) {
            result = newResult
            topFact *= n * 2 * (n * 2 - 1)
            botFact *= n
            newResult -= (topFact * x.pow(2 * n + 1)) / (2.0.pow(2 * n) * botFact * botFact * (2 * n + 1))

            n++
        }
        return BigDecimal(newResult).setScale(6, RoundingMode.HALF_EVEN).toDouble()
    }
}