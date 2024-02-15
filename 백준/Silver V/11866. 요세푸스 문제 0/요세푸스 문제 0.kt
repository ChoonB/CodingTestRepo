import java.util.LinkedList

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val queue = LinkedList<Int>()
    for (i in 1..n){
        queue.add(i)
    }

    var count = 0
    val resultList = ArrayList<Int>()

    while (queue.isNotEmpty()){
        count++
        val p = queue.poll()
        if (count%k == 0) resultList.add(p)
        else queue.add(p)
    }
    print("<${resultList.joinToString(", ")}>")

}