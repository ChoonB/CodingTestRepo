import java.util.LinkedList
import java.util.Queue

data class Point(val x: Int, val y: Int, val dist: Int, val wallBroken: Int)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln().toCharArray() }
    val visited = Array(n) { Array(m) { BooleanArray(2) } }

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    fun isValid(x: Int, y: Int) = x in 0 until n && y in 0 until m

    fun bfs(): Int {
        val queue: Queue<Point> = LinkedList()
        queue.offer(Point(0, 0, 1, 0))
        visited[0][0][0] = true

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            if (current.x == n - 1 && current.y == m - 1) {
                return current.dist
            }

            for (d in 0 until 4) {
                val nx = current.x + dx[d]
                val ny = current.y + dy[d]

                if (!isValid(nx, ny)) continue

                if (map[nx][ny] == '0' && !visited[nx][ny][current.wallBroken]) {
                    visited[nx][ny][current.wallBroken] = true
                    queue.offer(Point(nx, ny, current.dist + 1, current.wallBroken))
                } else if (map[nx][ny] == '1' && current.wallBroken == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true
                    queue.offer(Point(nx, ny, current.dist + 1, 1))
                }
            }
        }
        return -1
    }

    val result = bfs()
    println(result)
}
