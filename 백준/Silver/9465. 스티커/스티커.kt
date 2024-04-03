fun main() {
    val t = readln().toInt()

    repeat(t) {
        val n = readln().toInt()
        val stickers = Array(2) { IntArray(n) }
        val dp = Array(2) { IntArray(n) }

        for (i in 0 until 2) {
            val row = readln().split(" ").map { it.toInt() }
            for (j in 0 until n) {
                stickers[i][j] = row[j]
            }
        }

        dp[0][0] = stickers[0][0]
        dp[1][0] = stickers[1][0]

        if (n > 1) {
            dp[0][1] = stickers[1][0] + stickers[0][1]
            dp[1][1] = stickers[0][0] + stickers[1][1]

            for (i in 2 until n) {
                dp[0][i] = maxOf(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i]
                dp[1][i] = maxOf(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i]
            }
        }

        println(maxOf(dp[0][n - 1], dp[1][n - 1]))
    }
}