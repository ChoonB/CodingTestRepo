import java.util.*

data class Jewel(val weight: Int, val value: Int)

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    
    val jewels = Array(n) {
        val (weight, value) = readln().split(" ").map { it.toInt() }
        Jewel(weight, value)
    }
    
    val bags = IntArray(k) { readln().toInt() }
    
    jewels.sortWith(compareBy({ it.weight }, { -it.value }))
    bags.sort()
    
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    
    var totalValue = 0L
    var jewelIndex = 0
    
    for (bag in bags) {
        while (jewelIndex < n && jewels[jewelIndex].weight <= bag) {
            pq.offer(jewels[jewelIndex].value)
            jewelIndex++
        }
        if (pq.isNotEmpty()) {
            totalValue += pq.poll()
        }
    }
    
    println(totalValue)
}
