fun main() {
    val n = readln().toInt()

    val parent = IntArray(n + 1)
    val graph = Array(n + 1) { ArrayList<Int>() }

    repeat(n - 1) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    dfs(graph, parent, 1, 0)

    for (i in 2..n) {
        println(parent[i])
    }
}

fun dfs(graph: Array<ArrayList<Int>>, parent: IntArray, node: Int, parentNode: Int) {
    parent[node] = parentNode 
    for (nextNode in graph[node]) {
        if (nextNode != parentNode) { 
            dfs(graph, parent, nextNode, node)
        }
    }
}