import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val costs = Array(n) { IntArray(3) }

    for (i in 0 until n) {
        val (r, g, b) = readln().split(" ").map { it.toInt() }
        costs[i][0] = r
        costs[i][1] = g
        costs[i][2] = b
    }

    val dp = Array(n) { IntArray(3) }
    dp[0] = costs[0]

    for (i in 1 until n) {
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0]
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1]
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2]
    }

    val minCost = min(dp[n - 1][0], min(dp[n - 1][1], dp[n - 1][2]))
    println(minCost)
}
