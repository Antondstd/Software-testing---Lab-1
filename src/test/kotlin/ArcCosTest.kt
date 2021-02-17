import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.PI


internal class ArcCosTest {

    @Test
    fun `above zero`() {
        assertAll(
            { assertEquals(1.4706, ArcCos.calc(0.1), 0.0001) },
            { assertEquals(1.369438, ArcCos.calc(0.2), 0.0001) },
            { assertEquals(1.266103, ArcCos.calc(0.3), 0.0001) },
            { assertEquals(1.159279, ArcCos.calc(0.4), 0.0001) },
            { assertEquals(1.047197, ArcCos.calc(0.5), 0.0001) },
            { assertEquals(0.927295, ArcCos.calc(0.6), 0.0001) },
            { assertEquals(0.795398, ArcCos.calc(0.7), 0.0001) },
            { assertEquals(0.643501, ArcCos.calc(0.8), 0.0001) },
            { assertEquals(0.451026, ArcCos.calc(0.9), 0.0001) },

            )
    }

    @Test
    fun `below zero`() {
        assertAll(
            { assertEquals(1.670963, ArcCos.calc(-0.1), 0.0001) },
            { assertEquals(1.772154, ArcCos.calc(-0.2), 0.0001) },
            { assertEquals(1.875488, ArcCos.calc(-0.3), 0.0001) },
            { assertEquals(1.982313, ArcCos.calc(-0.4), 0.0001) },
            { assertEquals(2.094395, ArcCos.calc(-0.5), 0.0001) },
            { assertEquals(2.214297, ArcCos.calc(-0.6), 0.0001) },
            { assertEquals(2.346193, ArcCos.calc(-0.7), 0.0001) },
            { assertEquals(2.498091, ArcCos.calc(-0.8), 0.0001) },
            { assertEquals(2.690565, ArcCos.calc(-0.9), 0.0001) },

            )
    }

    @Test
    fun `zero and above - near edge`() {
        assertAll(
            { assertEquals(0.317560, ArcCos.calc(0.95), 0.0001) },
            { assertEquals(0.283794, ArcCos.calc(0.96), 0.0001) },
            { assertEquals(0.245565, ArcCos.calc(0.97), 0.0001) },
            { assertEquals(0.200334, ArcCos.calc(0.98), 0.0001) },
            { assertEquals(0.141539, ArcCos.calc(0.99), 0.0001) },
            { assertEquals(0.0, ArcCos.calc(1.0), 0.0001) },
        )
    }

    @Test
    fun `zero and below - near edge`() {
        assertAll(
            { assertEquals(2.824032, ArcCos.calc(-0.95), 0.0001) },
            { assertEquals(2.857798, ArcCos.calc(-0.96), 0.0001) },
            { assertEquals(2.896027, ArcCos.calc(-0.97), 0.0001) },
            { assertEquals(2.941257, ArcCos.calc(-0.98), 0.0001) },
            { assertEquals(3.000053, ArcCos.calc(-0.99), 0.0001) },
            { assertEquals(PI, ArcCos.calc(-1.0), 0.0001) },
        )
    }

    @Test
    fun `outside`() {
        assertAll(
            { assertEquals(Double.NaN, ArcCos.calc(-2.0), 0.0001) },
            { assertEquals(Double.NaN, ArcCos.calc(3.0), 0.0001) }
        )
    }

}