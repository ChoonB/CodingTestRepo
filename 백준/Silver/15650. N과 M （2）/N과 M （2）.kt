import java.io.*

val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val visited = BooleanArray(n) { false }
    val result = IntArray(m) { 0 }
    
    combination(0, n, m, visited, result, 1)
    
    bw.flush()
    bw.close()
}

fun combination(index: Int, n: Int, m: Int, visited: BooleanArray, result: IntArray, start: Int) {
    if (index == m) {
        for (i in 0 until m) {
            bw.write("${result[i]} ")
        }
        bw.newLine()
        return
    }

    for (i in start..n) {
        if (!visited[i - 1]) {
            visited[i - 1] = true
            result[index] = i
            combination(index + 1, n, m, visited, result, i + 1)
            visited[i - 1] = false
        }
    }
}
