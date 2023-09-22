import java.util.Stack;
class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.size()==0) {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.peek() != s.charAt(i)){
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        return stack.size()==0? 1 : 0;
    }
    
}