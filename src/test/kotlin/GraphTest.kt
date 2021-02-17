import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class GraphTest {

    // Test adding connections between nodes
    @Test
    fun addEdge() {
        val graph = Graph(5)

        graph.addEdge(0, arrayOf(1, 2))
        var expected = arrayOf(1, 2)
        assertArrayEquals(expected, graph.adjustanceList.elementAt(0).toArray())

        expected = arrayOf(0)
        assertArrayEquals(expected, graph.adjustanceList.elementAt(1).toArray())

        graph.addEdge(3, 4)
        expected = arrayOf(4)
        assertArrayEquals(expected, graph.adjustanceList.elementAt(3).toArray())

        expected = arrayOf()
        assertArrayEquals(expected, graph.adjustanceList.elementAt(5).toArray())
    }

    //Test Depth For Search algorithm
    @Test
    fun search() {
        val number = 8

        var graph = Graph(number)
        graph.addEdge(2, 1)
        graph.addEdge(2, 4)
        graph.addEdge(2, 5)
        graph.addEdge(3, 1)
        graph.addEdge(4, 7)
        graph.addEdge(5, 1)

        var expectedResult = arrayOf(null, 2, null, 1, 2, 1, null, 4)
        assertTrue(expectedResult.contentEquals(graph.search(2)))
        //Test search function can be reused and giving the same results
        assertArrayEquals(expectedResult, graph.search(2))

        //Test Node without connection to others
        expectedResult = arrayOf(null, null, null, null, null, null, null, null)
        assertArrayEquals(expectedResult, graph.search(0))


        graph = Graph(number)
        graph.addEdge(0, arrayOf(1,3,4))
        graph.addEdge(1, arrayOf(2,3,5,6))
        graph.addEdge(2, arrayOf(4,5,6))
        graph.addEdge(3,7)
        graph.addEdge(4, arrayOf(6,7))
        graph.addEdge(5,7)

        assertAll(
            {expectedResult = arrayOf(null,0,1,7,2,7,4,4)
            assertArrayEquals(expectedResult,graph.search(0))},

            {expectedResult = arrayOf(1,null,4,0,7,2,2,3)
                assertArrayEquals(expectedResult,graph.search(1))},

            {expectedResult = arrayOf(1,2,null,0,7,7,4,3)
                assertArrayEquals(expectedResult,graph.search(2))},

            {expectedResult = arrayOf(3,0,1,null,2,7,4,4)
                assertArrayEquals(expectedResult,graph.search(3))},

            {expectedResult = arrayOf(4,0,1,7,null,2,2,5)
                assertArrayEquals(expectedResult,graph.search(4))},

            {expectedResult = arrayOf(1,5,4,0,7,null,2,3)
                assertArrayEquals(expectedResult,graph.search(5))},

            {expectedResult = arrayOf(1,6,4,0,7,2,null,3)
                assertArrayEquals(expectedResult,graph.search(6))},

            {expectedResult = arrayOf(3,0,1,7,2,2,4,null)
                assertArrayEquals(expectedResult,graph.search(7))},

        )
    }
}