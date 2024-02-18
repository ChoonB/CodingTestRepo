fun main() {
    val n = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }
    var count = 0

    for (num in nums){
        if (num==1) continue
        else if (num<=3) {
            count++
        } else{
            if (isDecimal(num)) count++
        }
    }
    print(count)

}

fun isDecimal(num: Int) : Boolean{
    for (i in 2..Math.sqrt(num.toDouble()).toInt()){
        if (num % i == 0) return false
    }
    return true
}