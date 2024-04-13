import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val dp = Array(n + 1) { IntArray(n + 1) }

    for (i in 1..n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in 1..n) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + row[j - 1]
        }
    }

    val sb = StringBuilder()

    repeat(m) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
        val result = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]
        sb.append("$result\n")
    }

    println(sb)
}
