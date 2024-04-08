fun main() {
    val n = readln().toLong()
    println(fibonacci(n))
}

fun fibonacci(n: Long): Long {
    val matrix = arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))
    if (n <= 1) return n
    power(matrix, n - 1)
    return matrix[0][0] % 1000000007
}

fun power(matrix: Array<LongArray>, n: Long) {
    if (n <= 1) return
    power(matrix, n / 2)
    multiply(matrix, matrix)
    val temp = arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))
    if (n % 2 != 0L) multiply(matrix, temp)
}

fun multiply(matrixA: Array<LongArray>, matrixB: Array<LongArray>) {
    val x = (matrixA[0][0] * matrixB[0][0] + matrixA[0][1] * matrixB[1][0]) % 1000000007
    val y = (matrixA[0][0] * matrixB[0][1] + matrixA[0][1] * matrixB[1][1]) % 1000000007
    val z = (matrixA[1][0] * matrixB[0][0] + matrixA[1][1] * matrixB[1][0]) % 1000000007
    val w = (matrixA[1][0] * matrixB[0][1] + matrixA[1][1] * matrixB[1][1]) % 1000000007

    matrixA[0][0] = x
    matrixA[0][1] = y
    matrixA[1][0] = z
    matrixA[1][1] = w
}