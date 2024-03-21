import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val arr = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val result = Array(n) { IntArray(m) }
    val visited = Array(n) { BooleanArray(m) }

    var x = 0
    var y = 0
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (arr[i][j] == 2) {
                x = i
                y = j
            } else if (arr[i][j] == 0) visited[i][j] = true
        }
    }
    search(x, y, arr, visited, result, n, m)

    for (i in result.indices) {
        for (j in result[i].indices) {
            if (!visited[i][j]) result[i][j] = -1
            print("${result[i][j]} ")
        }
        println()
    }
}

private fun search(x: Int, y: Int, arr: Array<IntArray>, visited: Array<BooleanArray>, result: Array<IntArray>, n: Int, m: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(x to y)
    visited[x][y] = true

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    while (queue.isNotEmpty()) {
        val (tempX, tempY) = queue.poll()
        for (i in 0 until 4) {
            val a = tempX + dx[i]
            val b = tempY + dy[i]
            if (a in 0 until n && b in 0 until m) {
                if (!visited[a][b] && arr[a][b] == 1) {
                    visited[a][b] = true
                    result[a][b] = result[tempX][tempY] + 1
                    queue.add(a to b)
                }
            }
        }
    }
}

