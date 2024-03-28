import java.util.*

data class Edge(val to: Int, val weight: Int)

fun dijkstra(graph: Array<MutableList<Edge>>, start: Int): IntArray {
    val n = graph.size
    val dist = IntArray(n) { Int.MAX_VALUE }
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    dist[start] = 0
    pq.offer(start to 0)

    while (pq.isNotEmpty()) {
        val (node, d) = pq.poll()
        if (d > dist[node]) continue
        for (edge in graph[node]) {
            val nextDist = d + edge.weight
            if (nextDist < dist[edge.to]) {
                dist[edge.to] = nextDist
                pq.offer(edge.to to nextDist)
            }
        }
    }
    return dist
}

fun main() {
    val (n, m, x) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Edge>() }

    repeat(m) {
        val (start, end, weight) = readln().split(" ").map { it.toInt() }
        graph[start].add(Edge(end, weight))
    }

    val toX = dijkstra(graph, x)
    var maxDistance = 0

    for (i in 1..n) {
        if (i == x) continue
        val fromI = dijkstra(graph, i)
        maxDistance = maxOf(maxDistance, fromI[x] + toX[i])
    }

    println(maxDistance)
}
