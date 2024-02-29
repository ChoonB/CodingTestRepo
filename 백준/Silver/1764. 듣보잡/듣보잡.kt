fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val set = mutableSetOf<String>()
    repeat(n){
       set.add(readln())
    }

    val answerList = ArrayList<String>()
    repeat(m){
        val str = readln()
        if (str in set){
            answerList.add(str)
        }
    }
    answerList.sort()
    println(answerList.size)
    answerList.forEach{ println(it) }

}