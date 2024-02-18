import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val graph = ArrayList<ArrayList<Int>>()

    repeat(n+1){
        graph.add(ArrayList())
    }

    repeat(m){
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    val check = BooleanArray(n+1)
    check[0] = true

    print(bfs(1, check, graph))
}

fun bfs(start: Int, check: BooleanArray, graph: ArrayList<ArrayList<Int>>): Int{
    check[start] = true
    val queue:Queue<Int> = LinkedList()
    var count = 0

    queue.add(start)
    check[start] = true

    while (queue.isNotEmpty()){
        val n = queue.poll()
        count++

        for (nextNode in graph[n]){
            if (!check[nextNode]){
                queue.add(nextNode)
                check[nextNode] = true
            }
        }
    }

    return count -1
}