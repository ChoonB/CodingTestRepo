import java.util.*

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val visited = BooleanArray(100001){false}
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    queue.offer(Pair(n, 0))
    visited[n] = true

    while (queue.isNotEmpty()) {
        val (current, time) = queue.poll()

        if (current == k) {
            println(time)
            break
        }

        val next = listOf(current - 1, current + 1, current * 2)

        for (p in next) {
            if (p in 0..100000 && !visited[p]) {
                queue.offer(Pair(p, time + 1))
                visited[p] = true
            }
        }
    }

}