import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int l = B.length;
        int b = 0;
        
        for(int i=0; i<l; i++){
            for(int j=b; j<l; j++){
                if(B[j]>A[i]){
                    answer++;
                    b++;
                    break;
                } else{
                    b++;
                }
            }
        }
        
        
        return answer;
    }
}