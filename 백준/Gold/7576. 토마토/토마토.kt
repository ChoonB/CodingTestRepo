import java.util.*

data class Point(val x: Int, val y: Int)

fun main() {
    val (m,n) = readln().split(" ").map{ it.toInt() }
    val box = Array(n) { IntArray(m) }
    val visited = Array(n) { BooleanArray(m) }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    val queue: Queue<Point> = LinkedList()

    for (i in 0 until n) {
        val arr = readln().split(" ").map{ it.toInt() }
        for (j in 0 until m) {
            box[i][j] = arr[j]
            if (box[i][j] == 1) {
                queue.add(Point(i, j))
                visited[i][j] = true
            }
        }
    }

    var days = -1
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val cur = queue.poll()
            for (j in 0 until 4) {
                val nx = cur.x + dx[j]
                val ny = cur.y + dy[j]
                if (nx in 0 until n && ny in 0 until m && box[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.add(Point(nx, ny))
                    visited[nx][ny] = true
                    box[nx][ny] = 1
                }
            }
        }
        days++
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (box[i][j] == 0) {
                println(-1)
                return
            }
        }
    }
    println(days)
}
