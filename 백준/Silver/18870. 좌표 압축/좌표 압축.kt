fun main() {
    val n = readln().toInt()
    val coords = readln().split(" ").map(String::toInt)
    val sortedCoords = coords.toSet().toList().sorted()

    val compressedCoords = sortedCoords.withIndex().associate { (index, value) -> value to index }

    val result = StringBuilder()
    for (coord in coords) {
        result.append(compressedCoords[coord]).append(" ")
    }
    println(result)
}
