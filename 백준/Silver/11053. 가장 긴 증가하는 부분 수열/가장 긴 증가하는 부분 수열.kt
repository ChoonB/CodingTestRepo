fun main() {
    val n = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }
    
    val dp = IntArray(n) { 1 }

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (nums[i] > nums[j]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }

    print(dp.maxOrNull() ?: 0)
}