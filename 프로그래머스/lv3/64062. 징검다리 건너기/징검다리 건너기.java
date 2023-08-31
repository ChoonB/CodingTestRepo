import java.util.*;
class Solution {
    boolean isPossible(int n, int k, int[] stones){
        int count = 0;
        for(int stone : stones){
            if(stone-n<0){
                count++;
                if(count>=k) return false;
            } else {
                count = 0;
            }
        }
        
        return true;
    }
    
    
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int min = 1;
        int max = 200000000;
        
        while(min<=max){
            int mid = (min+max)/2;
            
            if(isPossible(mid,k,stones)){
                min = mid+1;
                answer = Math.max(answer, mid);
            } else {
                max = mid-1;
            }
        }
        return answer;
    }
}