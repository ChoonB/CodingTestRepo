import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val array = IntArray(n + 1)
    val prefixSum = IntArray(n + 1)

    val st2 = StringTokenizer(br.readLine())
    for (i in 1..n) {
        array[i] = st2.nextToken().toInt()
        prefixSum[i] = prefixSum[i - 1] + array[i]
    }

    val sb = StringBuilder()
    repeat(m) {
        val st3 = StringTokenizer(br.readLine())
        val i = st3.nextToken().toInt()
        val j = st3.nextToken().toInt()
        sb.append("${prefixSum[j] - prefixSum[i - 1]}\n")
    }
    println(sb.toString())
}