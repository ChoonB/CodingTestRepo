import java.util.Stack
fun main() {
    val n = readln().toInt()
    repeat(n){
        val str = readln()
        val stack:Stack<Char> = Stack()
        var flag = true
        for (c in str){
            when(c){
                '(' -> {
                    stack.push(c)
                }
                ')' -> {
                    if (stack.isEmpty()){
                        flag = false
                        break
                    }
                    stack.pop()
                }
            }
        }
        if (!flag) println("NO")
        else if (stack.isEmpty()) println("YES")
        else println("NO")
    }
}