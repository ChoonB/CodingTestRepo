fun main() {
    val n = readln().toInt()
    val na = readln().split(" ").map { it.toInt() }.sorted()
    val m = readln().toInt()
    val ma = readln().split(" ").map { it.toInt() }
    for (num in ma){
        val ans = na.binarySearch(num)
        if (ans>=0) println(1)
        else println(0)
    }
}