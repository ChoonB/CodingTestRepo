fun main() {
    val n = readln().toInt()
    val col = IntArray(n)
    var count = 0
    count = nQueen(0, n, col, count)
    println(count)
}

fun nQueen(row: Int, n: Int, col: IntArray, count: Int): Int {
    var resultCount = count
    if (row == n) {
        return resultCount + 1
    }
    for (i in 0 until n) {
        col[row] = i
        if (isPossible(row, col)) {
            resultCount = nQueen(row + 1, n, col, resultCount)
        }
    }
    return resultCount
}

fun isPossible(row: Int, col: IntArray): Boolean {
    for (i in 0 until row) {
        if (col[i] == col[row]) return false
        if (Math.abs(col[i] - col[row]) == row - i) return false
    }
    return true
}
