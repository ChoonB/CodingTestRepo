import java.io.*
import java.util.*

private lateinit var br: BufferedReader

private var N = 0
private lateinit var adjList: MutableList<MutableList<Node>>
private lateinit var isVisited: BooleanArray
private lateinit var dist: IntArray

data class Node(var num: Int = 0, var weight: Int = 0)

fun main() {
    br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()
    
    input()


    var ans = dijkstra(1)
    ans = dijkstra(dist.indexOf(ans))

    sb.append(ans)
    bw.write(sb.toString())
    bw.close()
}

private fun dijkstra(startNodeNum: Int): Int {
    val comp = Comparator<Node> { o1, o2 -> o1.weight - o2.weight }
    val que = PriorityQueue(comp)
    isVisited = BooleanArray(N + 1)
    dist = IntArray(N + 1) { -1 }

    dist[startNodeNum] = 0
    que.offer(Node(startNodeNum, 0))

    for (i in generateSequence { 0 }) {
        if (que.isEmpty()) break
        val pollNode = que.poll()

        if (isVisited[pollNode.num]) continue
        isVisited[pollNode.num] = true

        adjList[pollNode.num].forEach { nextNode ->

 
            if (!isVisited[nextNode.num] && dist[nextNode.num] < nextNode.weight + dist[pollNode.num]) {
                dist[nextNode.num] = nextNode.weight + dist[pollNode.num]
                que.offer(Node(nextNode.num, dist[nextNode.num]))
            }
        }
    }

    return dist.max()
}

fun input() {
    N = br.readLine().toInt()

    adjList = ArrayList()
    repeat(N + 1) {
        adjList.add(ArrayList())
    }

    repeat(N - 1) {
        val st = StringTokenizer(br.readLine())
        val parentNode = st.nextToken().toInt()
        val childNode = st.nextToken().toInt()
        val weight = st.nextToken().toInt()

        adjList[parentNode].add(Node(childNode, weight))
        adjList[childNode].add(Node(parentNode, weight))
    }
} 