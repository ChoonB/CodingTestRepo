import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 1;
        int max = Arrays.stream(times).max().getAsInt();
        long end = (long) max * n;
        
        long mid, sum;
        
        while(start <= end){
            mid = (start + end) / 2;
            sum = 0;
            for(int t : times){
                sum += mid/t;
            }
            
            if(sum < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}