import java.util.Deque
import java.util.ArrayDeque
fun main() {
    val n = readln().toInt()
    if (n==1) {
        print(1)
        return
    }

    val d: Deque<Int> = ArrayDeque()
    var a = 1
    repeat(n){
        d.addFirst(a)
        a++
    }

    while (d.size>1){
        val e1 = d.removeLast()
        if (d.size==1) {
            print(d.pop())
            return
        }
        val e2 = d.removeLast()
        d.addFirst(e2)
    }
    print(d.pop())
}