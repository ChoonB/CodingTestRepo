fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val mapStringInt: HashMap<String, Int> = hashMapOf()
    val mapIntString: HashMap<Int, String> = hashMapOf()

    for (i in 1..n){
        val string = readln()
        mapStringInt[string] = i
        mapIntString[i] = string
    }

    repeat(m){
        val input = readln()
        val num = input.toIntOrNull()

        if (num==null){
            println(mapStringInt[input])
        } else {
            println(mapIntString[num])
        }
    }
}