import kotlin.math.max

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val weights = IntArray(N + 1)
    val values = IntArray(N + 1)

    for (i in 1..N) {
        val (W, V) = readln().split(" ").map { it.toInt() }
        weights[i] = W
        values[i] = V
    }

    val dp = Array(N + 1) { IntArray(K + 1) { 0 } }

    for (i in 1..N) {
        for (j in 1..K) {
            dp[i][j] = dp[i - 1][j]
            if (j - weights[i] >= 0) {
                dp[i][j] = max(dp[i][j], dp[i - 1][j - weights[i]] + values[i])
            }
        }
    }

    println(dp[N][K])
}
