data class Node(val index: Int, val distance: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val tc = readLine().toInt()

    repeat(tc) {
        val (n, m, w) = readLine().split(" ").map { it.toInt() }

        val graph = Array(n + 1) { mutableListOf<Node>() }

        repeat(m) {
            val (s, e, t) = readLine().split(" ").map { it.toInt() }
            graph[s].add(Node(e, t))
            graph[e].add(Node(s, t))
        }

        repeat(w) {
            val (s, e, t) = readLine().split(" ").map { it.toInt() }
            graph[s].add(Node(e, -t))
        }

        if (timeTravel(n, graph))
            println("YES")
        else
            println("NO")
    }
}

fun timeTravel(n: Int, graph: Array<MutableList<Node>>): Boolean {
    val result = IntArray(n + 1) { 10000000 }

    result[1] = 0

    var update = false
    for (i in 1 until n) {
        update = false
        for (j in 1..n) {
            for (node in graph[j]) {
                val idx = node.index
                val next = node.distance + result[j]

                if (result[idx] > next) {
                    result[idx] = next
                    update = true
                }
            }
        }
        if (!update) break
    }

    if (update) {
        for (i in 1..n) {
            for (node in graph[i]) {
                val idx = node.index
                val next = node.distance + result[i]

                if (result[idx] > next) {
                    return true
                }
            }
        }
    }
    return false
}

