fun main() {
    val n = readln().toInt()

    val triangle = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val dp = Array(n) { IntArray(it + 1) }

    dp[0][0] = triangle[0][0]

    for (i in 1 until n) {
        for (j in 0..i) {
            dp[i][j] = triangle[i][j] + maxOf(getValue(dp, i - 1, j - 1), getValue(dp, i - 1, j))
        }
    }

    println(dp[n - 1].maxOrNull())
}

fun getValue(dp: Array<IntArray>, row: Int, col: Int): Int {
    return if (row < 0 || col < 0 || col >= dp[row].size) 0 else dp[row][col]
}
