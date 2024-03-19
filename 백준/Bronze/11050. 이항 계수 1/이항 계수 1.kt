import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val result = binomialCoefficient(n, k)
    bw.write("$result\n")

    bw.flush()
    bw.close()
}

fun binomialCoefficient(n: Int, k: Int): Int {
    if (k == 0 || k == n) {
        return 1
    }

    val dp = Array(n + 1) { IntArray(k + 1) }

    for (i in 0..n) {
        for (j in 0..minOf(i, k)) {
            if (j == 0 || j == i) {
                dp[i][j] = 1
            } else {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007
            }
        }
    }

    return dp[n][k]
}
