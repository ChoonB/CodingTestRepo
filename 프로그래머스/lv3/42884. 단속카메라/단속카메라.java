import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1], b[1]));
        int answer = 0;
        int min = -30000;
        
        for(int[] r : routes){
            int start = r[0];
            int end = r[1];
            
            if(start>min){
                answer++;
                min = end;
            }
        }
        
        return answer;
    }
}