fun main() {
    val n = readln().toInt()
    val times = readln().split(" ").map { it.toInt() }.sorted()

    var total = 0
    var accTime = 0

    for (time in times) {
        accTime += time
        total += accTime
    }

    println(total)
}