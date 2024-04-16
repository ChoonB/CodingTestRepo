import java.util.PriorityQueue

data class Position(val p: Int, val time: Int)

fun main() {
    val (N, K) = readln().split(' ').map{it.toInt()}

    val visited = BooleanArray(100001){false}
    val queue = PriorityQueue<Position>{p1, p2 -> p1.time - p2.time}

    queue.offer(Position(N,0))
    visited[N] = true

    while(queue.isNotEmpty()){
        val next = queue.poll()
        visited[next.p] = true

        if(next.p == K){
            print(next.time)
            break
        }

        if(next.p * 2 < 100001 && !visited[next.p * 2]){
            queue.offer(Position(next.p * 2, next.time))
        }
        if(next.p + 1 < 100001 && !visited[next.p + 1]){
            queue.offer(Position(next.p + 1, next.time + 1))
        }
        if(next.p - 1 >= 0 && !visited[next.p - 1]){
            queue.offer(Position(next.p - 1, next.time + 1))
        }
    }
}