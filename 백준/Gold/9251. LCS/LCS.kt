fun main() {
    val str1 = readln()
    val str2 = readln()

    val answer = longestCommonSubsequence(str1, str2)
    println(answer)
}

fun longestCommonSubsequence(str1: String, str2: String): Int {
    val m = str1.length
    val n = str2.length
    val dp = Array(m + 1) { IntArray(n + 1) }

    for (i in 0..m) {
        for (j in 0..n) {
            if (i == 0 || j == 0) {
                dp[i][j] = 0
            } else if (str1[i - 1] == str2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    return dp[m][n]
}
