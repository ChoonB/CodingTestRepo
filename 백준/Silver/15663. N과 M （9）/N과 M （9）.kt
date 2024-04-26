import java.util.*

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val n = input[0]
    val m = input[1]

    val numbers = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    val visited = BooleanArray(n)

    val result = LinkedList<Int>()
    val answer = LinkedList<List<Int>>()

    fun backtracking(depth: Int) {
        if (depth == m) {
            answer.add(result.toList())
            return
        }

        var prev = 0
        for (i in 0 until n) {
            if (!visited[i] && prev != numbers[i]) {
                visited[i] = true
                result.add(numbers[i])
                prev = numbers[i]
                backtracking(depth + 1)
                visited[i] = false
                result.removeLast()
            }
        }
    }

    backtracking(0)

    for (list in answer) {
        println(list.joinToString(" "))
    }
}