fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Pair<Int, String>>()

    repeat(n){
        val (ageStr, name) = readln().split(" ")
        val age = ageStr.toInt()
        list.add(age to name)
    }
    val sortedList = list.sortedWith(compareBy { it.first })
    sortedList.forEach{
        (age, name) -> println("$age $name")
    }

}