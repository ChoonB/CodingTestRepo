import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val m = br.readLine().toInt()
    var bitSet = 0

    repeat(m) {
        val input = br.readLine().split(" ")
        val op = input[0]
        val x = input.getOrNull(1)?.toIntOrNull() ?: 0

        when (op) {
            "add" -> bitSet = bitSet or (1 shl x)
            "remove" -> bitSet = bitSet and (1 shl x).inv()
            "check" -> {
                if (bitSet and (1 shl x) != 0) bw.write("1\n")
                else bw.write("0\n")
            }
            "toggle" -> bitSet = bitSet xor (1 shl x)
            "all" -> bitSet = (1 shl 21) - 1
            "empty" -> bitSet = 0
        }
    }

    br.close()
    bw.close()
}
