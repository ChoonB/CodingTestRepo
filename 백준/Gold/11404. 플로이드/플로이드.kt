val INF = 11111111

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()

    val graph = Array(n) { IntArray(n) { INF } }

    repeat(n) { i ->
        graph[i][i] = 0
    }

    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a - 1][b - 1] = minOf(graph[a - 1][b - 1], c)
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                graph[i][j] = minOf(graph[i][j], graph[i][k] + graph[k][j])
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            print("${if (graph[i][j] == INF) 0 else graph[i][j]} ")
        }
        println()
    }
}