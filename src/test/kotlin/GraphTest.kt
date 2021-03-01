import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

internal class GraphTest {
    val number = 8
    lateinit var expectedResult: Array<Int?>
    lateinit var graph: Graph


    @Test
    fun `connection from both sides between nodes`() {
        graph = Graph(2)
        graph.addEdge(0, 1)
        expectedResult = arrayOf(0)
        assertArrayEquals(expectedResult, graph.adjustanceList.get(1).toArray())
    }


    @Test
    fun `when no connection to others`() {
        graph = Graph(number)
        graph.addEdge(2, 1)
        graph.addEdge(2, 4)
        graph.addEdge(2, 5)
        graph.addEdge(3, 1)
        graph.addEdge(4, 7)
        graph.addEdge(5, 1)

        expectedResult = arrayOf(null, 2, null, 1, 2, 1, null, 4)
        assertArrayEquals(expectedResult, graph.search(2))
    }

    @Test
    fun `search from every node`() {

        graph = Graph(number)
        graph.addEdge(0, arrayOf(1, 3, 4))
        graph.addEdge(1, arrayOf(2, 3, 5, 6))
        graph.addEdge(2, arrayOf(4, 5, 6))
        graph.addEdge(3, 7)
        graph.addEdge(4, arrayOf(6, 7))
        graph.addEdge(5, 7)

        assertAll(
            {
                expectedResult = arrayOf(null, 0, 1, 7, 2, 7, 4, 4)
                assertArrayEquals(expectedResult, graph.search(0))
            },

            {
                expectedResult = arrayOf(1, null, 4, 0, 7, 2, 2, 3)
                assertArrayEquals(expectedResult, graph.search(1))
            },

            {
                expectedResult = arrayOf(1, 2, null, 0, 7, 7, 4, 3)
                assertArrayEquals(expectedResult, graph.search(2))
            },

            {
                expectedResult = arrayOf(3, 0, 1, null, 2, 7, 4, 4)
                assertArrayEquals(expectedResult, graph.search(3))
            },

            {
                expectedResult = arrayOf(4, 0, 1, 7, null, 2, 2, 5)
                assertArrayEquals(expectedResult, graph.search(4))
            },

            {
                expectedResult = arrayOf(1, 5, 4, 0, 7, null, 2, 3)
                assertArrayEquals(expectedResult, graph.search(5))
            },

            {
                expectedResult = arrayOf(1, 6, 4, 0, 7, 2, null, 3)
                assertArrayEquals(expectedResult, graph.search(6))
            },

            {
                expectedResult = arrayOf(3, 0, 1, 7, 2, 2, 4, null)
                assertArrayEquals(expectedResult, graph.search(7))
            },

            )
    }
}