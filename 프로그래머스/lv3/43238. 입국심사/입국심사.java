import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = times[0];
        long end = times[times.length-1] * (long) n;
        
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