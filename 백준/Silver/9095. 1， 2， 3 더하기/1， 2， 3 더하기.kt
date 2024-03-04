fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        println(count(n))
    }
}

fun count(n: Int): Int {
    if (n == 1) return 1
    if (n == 2) return 2
    if (n == 3) return 4

    val dp = IntArray(n + 1)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for (i in 4..n) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    }

    return dp[n]
}
