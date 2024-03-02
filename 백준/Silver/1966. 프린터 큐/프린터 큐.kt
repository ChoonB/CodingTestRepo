data class Print(val num: Int, val priority: Int)

fun main() {
    val nOfTestCase = readln().toInt()

    repeat(nOfTestCase) {
        val (N, M) = readln().split(" ").map { it.toInt() }
        val importance = readln().split(" ").map { it.toInt() }

        val list = importance.mapIndexed { index, value -> Print(index, value) }.toMutableList()

        var idx = 0

        while (true) {
            val current = list.removeAt(0)
            if (list.any { it.priority > current.priority }) {
                list.add(current)
            } else {
                idx++
                if (current.num == M) break
            }
        }
        println(idx)
    }
}