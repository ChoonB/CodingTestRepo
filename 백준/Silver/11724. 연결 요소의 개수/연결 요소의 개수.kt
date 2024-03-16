import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(n + 1) { false }

    repeat(m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    var count = 0
    for (i in 1..n) {
        if (!visited[i]) {
            bfs(graph, visited, i)
            count++
        }
    }

    println(count)
}

fun bfs(graph: Array<MutableList<Int>>, visited: BooleanArray, start: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        for (adjNode in graph[node]) {
            if (!visited[adjNode]) {
                queue.add(adjNode)
                visited[adjNode] = true
            }
        }
    }
}
