import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push('(');
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) answer = true;
        return answer;
    }
}