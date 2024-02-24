import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val deque = LinkedList<Int>()

    repeat(n) {
        val command = br.readLine().split(" ")

        when (command[0]) {
            "push_front" -> {
                val x = command[1].toInt()
                deque.addFirst(x)
            }
            "push_back" -> {
                val x = command[1].toInt()
                deque.addLast(x)
            }
            "pop_front" -> {
                if (deque.isEmpty()) bw.write("-1\n")
                else bw.write("${deque.pollFirst()}\n")
            }
            "pop_back" -> {
                if (deque.isEmpty()) bw.write("-1\n")
                else bw.write("${deque.pollLast()}\n")
            }
            "size" -> {
                bw.write("${deque.size}\n")
            }
            "empty" -> {
                if (deque.isEmpty()) bw.write("1\n")
                else bw.write("0\n")
            }
            "front" -> {
                if (deque.isEmpty()) bw.write("-1\n")
                else bw.write("${deque.first()}\n")
            }
            "back" -> {
                if (deque.isEmpty()) bw.write("-1\n")
                else bw.write("${deque.last()}\n")
            }
        }
    }

    bw.flush()
    bw.close()
}
