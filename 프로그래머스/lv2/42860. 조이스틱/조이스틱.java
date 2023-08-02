import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] ch = name.toCharArray();
        int l = name.length();
        int m = l-1;
        
        for(int i=0; i< l; i++){
            int index = i+1;
            while(index<l && ch[index] == 'A'){
                index++;
            }
            m = Math.min(m, i*2+l-index);
            m = Math.min(m, (l-index)*2 +i);
            
            int numA = (int) ch[i] - (int)'A';
            int numZ = (int) 'Z' - (int) ch[i] + 1;
            answer += Math.min(numA, numZ);
        }
        answer += m;
        
        return answer;
    }
}