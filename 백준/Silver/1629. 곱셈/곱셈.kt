fun main() {
    val (A, B, C) = readln().split(" ").map { it.toLong() }
    println(power(A, B, C))
}

fun power(A: Long, B: Long, C: Long): Long {
    if (B == 0L) return 1L

    var temp = power(A, B / 2, C) % C
    temp = (temp * temp) % C

    if (B % 2 == 0L) {
        return temp
    } else {
        return (temp * A) % C
    }
}