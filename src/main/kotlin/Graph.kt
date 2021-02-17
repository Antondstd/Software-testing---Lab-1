class Graph(private val number: Int) {
    var adjustanceList = mutableListOf<HashSet<Int>>()

    init {
        for (i in 0..number)
            this.adjustanceList.add(hashSetOf())
    }

    fun addEdge(from: Int, to: Int) {

        this.adjustanceList[from].add(to)
        this.adjustanceList[to].add(from)

    }

    fun addEdge(from: Int, to: Array<Int>) {
        for (node in to) {
            this.adjustanceList[from].add(node)
            this.adjustanceList[node].add(from)
        }
    }


    fun search(startNode: Int): Array<Int?> {
        var parentList: Array<Int?> = arrayOfNulls<Int?>(number)
        var visited: BooleanArray = BooleanArray(number)

        dfs(startNode, parentList, visited)



        return parentList
    }

    private fun dfs(at: Int, parentList: Array<Int?>, visited: BooleanArray) {
        visited[at] = true

        for (value in adjustanceList[at]) {
            if (visited[value])
                continue
            parentList[value] = at
            dfs(value, parentList, visited)
        }
    }
}