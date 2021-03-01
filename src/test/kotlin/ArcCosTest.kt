import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import kotlin.math.PI
import kotlin.test.assertNotEquals


internal class ArcCosTest {

    @ParameterizedTest
    @CsvFileSource(resources = arrayOf("/arccos_aboveZero.csv"), numLinesToSkip = 1, delimiter = ';')
    fun `above zero`(expected: Double, input: Double) {

        assertEquals(expected, ArcCos.calc(input), 0.0001)
    }

    @ParameterizedTest
    @CsvFileSource(resources = arrayOf("/arccos_belowZero.csv"), numLinesToSkip = 1, delimiter = ';')
    fun `below zero`(expected: Double, input: Double) {
        assertEquals(expected, ArcCos.calc(input), 0.0001)
    }

    @Test
    fun `at edge`() {
        assertAll(
            { assertNotEquals(3.14, ArcCos.calc(-1.0), "Power series isn't accurate near edges") },
            { assertNotEquals(0.0, ArcCos.calc(1.0), "Power series isn't accurate near edges") }
        )
    }

    @Test
    fun `zero`() {
        assertEquals(PI / 2, ArcCos.calc(0.0), 0.0001)
    }

    @Test
    fun outside() {
        assertAll(
            { assertEquals(Double.NaN, ArcCos.calc(-2.0), 0.0001) },
            { assertEquals(Double.NaN, ArcCos.calc(3.0), 0.0001) }
        )
    }
}