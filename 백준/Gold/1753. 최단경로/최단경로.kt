import java.util.*

data class Edge(val to: Int, val weight: Int)

fun main() {
    val INF = Int.MAX_VALUE
    val input = readln().split(" ")
    val V = input[0].toInt()
    val E = input[1].toInt()
    val start = readln().toInt()
    val graph = Array(V + 1) { mutableListOf<Edge>() }
    val distance = IntArray(V + 1) { INF }
    val visited = BooleanArray(V + 1)

    for (i in 0 until E) {
        val (u, v, w) = readln().split(" ").map { it.toInt() }
        graph[u].add(Edge(v, w))
    }

    fun dijkstra(start: Int) {
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        pq.offer(start to 0)
        distance[start] = 0

        while (pq.isNotEmpty()) {
            val (current, dist) = pq.poll()
            if (visited[current]) continue
            visited[current] = true

            for (next in graph[current]) {
                if (distance[next.to] > dist + next.weight) {
                    distance[next.to] = dist + next.weight
                    pq.offer(next.to to distance[next.to])
                }
            }
        }
    }

    dijkstra(start)

    for (i in 1..V) {
        if (distance[i] == INF) println("INF")
        else println(distance[i])
    }
}
