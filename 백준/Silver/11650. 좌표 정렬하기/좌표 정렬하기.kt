fun main() {
    val n = readln().toInt()
    val list: ArrayList<Pair<Int,Int>> = arrayListOf()
    repeat(n){
        val (x,y) = readln().split(" ").map { it.toInt() }
        list.add(Pair(x,y))
    }
    val sortedList = list.sortedWith(compareBy({it.first}, {it.second}))
    for (pair in sortedList){
        println("${pair.first} ${pair.second}")
    }
}