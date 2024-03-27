import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Node(val vertex: Int, val weight: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val V = br.readLine().toInt()

    val tree = Array(V + 1) { ArrayList<Node>() }
    val visited = BooleanArray(V + 1)

    repeat(V) {
        val st = StringTokenizer(br.readLine())
        val vertex = st.nextToken().toInt()

        while (true) {
            val v = st.nextToken().toInt()
            if (v == -1) break
            val weight = st.nextToken().toInt()
            tree[vertex].add(Node(v, weight))
        }
    }

    var maxDistance = 0
    var farthestNode = 0

    fun dfs(node: Int, distance: Int) {
        visited[node] = true

        if (distance > maxDistance) {
            maxDistance = distance
            farthestNode = node
        }

        for (adjacent in tree[node]) {
            if (!visited[adjacent.vertex]) {
                dfs(adjacent.vertex, distance + adjacent.weight)
            }
        }
    }

    dfs(1, 0)
    visited.fill(false)
    dfs(farthestNode, 0)

    println(maxDistance)
}
