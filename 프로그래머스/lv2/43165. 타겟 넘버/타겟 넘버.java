import java.util.*;
class Solution {
    private static int answer = 0;
    
    private static void dfs(int[] numbers, int target, int sum, int depth){
        if (depth == numbers.length){
            if (target == sum) answer++;
        } else{
            dfs(numbers, target, sum+numbers[depth], depth+1);
            dfs(numbers, target, sum-numbers[depth], depth+1);
        }
    }
    
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
}