fun main() {
    val n = readln().toInt()
    val paper = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        val arr = readln().split(" ").map { it.toInt() }
        for (j in 0 until n) {
            paper[i][j] = arr[j]
        }
    }

    val result = cutPaper(paper, 0, 0, n)
    println(result.white)
    println(result.blue)

}

data class Result(val white: Int, val blue: Int)

fun cutPaper(paper: Array<IntArray>, x: Int, y: Int, size: Int): Result {
    val color = paper[x][y]
    var whiteCount = 0
    var blueCount = 0

    for (i in x until x + size) {
        for (j in y until y + size) {
            if (paper[i][j] != color) {
                val halfSize = size / 2
                val topLeft = cutPaper(paper, x, y, halfSize)
                val topRight = cutPaper(paper, x, y + halfSize, halfSize)
                val bottomLeft = cutPaper(paper, x + halfSize, y, halfSize)
                val bottomRight = cutPaper(paper, x + halfSize, y + halfSize, halfSize)
                return Result(
                    white = topLeft.white + topRight.white + bottomLeft.white + bottomRight.white,
                    blue = topLeft.blue + topRight.blue + bottomLeft.blue + bottomRight.blue
                )
            }
        }
    }

    if (color == 0) whiteCount++ else blueCount++
    return Result(whiteCount, blueCount)
}