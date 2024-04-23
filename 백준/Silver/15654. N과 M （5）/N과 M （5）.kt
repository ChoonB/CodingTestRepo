import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val arr = IntArray(n)
    for (i in 0 until n) {
        arr[i] = sc.nextInt()
    }
    arr.sort()
    val visited = BooleanArray(n)
    val output = IntArray(m)
    dfs(arr, visited, output, n, m, 0)
}

fun dfs(arr: IntArray, visited: BooleanArray, output: IntArray, n: Int, m: Int, depth: Int) {
    if (depth == m) {
        for (i in 0 until m) {
            print("${output[i]} ")
        }
        println()
        return
    }
    for (i in 0 until n) {
        if (!visited[i]) {
            visited[i] = true
            output[depth] = arr[i]
            dfs(arr, visited, output, n, m, depth + 1)
            visited[i] = false
        }
    }
}