import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val queue = LinkedList<Int>()

    repeat(n) {
        val command = br.readLine().split(" ")

        when (command[0]) {
            "push" -> {
                val x = command[1].toInt()
                queue.offer(x)
            }
            "pop" -> {
                if (queue.isEmpty()) bw.write("-1\n")
                else bw.write("${queue.poll()}\n")
            }
            "size" -> {
                bw.write("${queue.size}\n")
            }
            "empty" -> {
                if (queue.isEmpty()) bw.write("1\n")
                else bw.write("0\n")
            }
            "front" -> {
                if (queue.isEmpty()) bw.write("-1\n")
                else bw.write("${queue.peek()}\n")
            }
            "back" -> {
                if (queue.isEmpty()) bw.write("-1\n")
                else bw.write("${queue.last()}\n")
            }
        }
    }

    bw.flush()
    bw.close()
}
