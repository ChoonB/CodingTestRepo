fun main() {
    val MOD = 1_000_000_000
    val n = readln().toInt()

    val dp = Array(n + 1) { Array(10) { IntArray(1 shl 10) } }

    for (j in 1..9) {
        dp[1][j][1 shl j] = 1
    }

    for (i in 2..n) {
        for (j in 0..9) {
            for (k in 0 until (1 shl 10)) {
                if (j > 0) {
                    dp[i][j][k or (1 shl j)] = (dp[i][j][k or (1 shl j)] + dp[i - 1][j - 1][k]) % MOD
                }
                if (j < 9) {
                    dp[i][j][k or (1 shl j)] = (dp[i][j][k or (1 shl j)] + dp[i - 1][j + 1][k]) % MOD
                }
            }
        }
    }

    var result = 0
    for (j in 0..9) {
        result = (result + dp[n][j][(1 shl 10) - 1]) % MOD
    }

    println(result)
}
