import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int l = B.length;
        int a = 0;
        int b = 0;
        
        while(a<l && b<l){
            if(B[b] > A[a]){
                answer++;
                a++;
                b++;
            } else{
                b++;
            }
        }
        
        
        return answer;
    }
}