fun main() {
    val (n, r, c) = readln().split(" ").map { it.toInt() }
    print(recur(n,r,c))
}

fun recur(n: Int, r: Int, c: Int): Int {
    if (n == 0) return 0

    val halfSize = 1 shl (n - 1)
    val quadrant = when {
        r < halfSize && c < halfSize -> 0
        r < halfSize && c >= halfSize -> 1
        r >= halfSize && c < halfSize -> 2
        else -> 3
    }

    val offset = halfSize * halfSize * quadrant
    return offset + recur(n - 1, r % halfSize, c % halfSize)
}