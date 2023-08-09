import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1,gems.length};
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();
        
        int left = 0, right = 0;
        int minLength = 100000;
        
        while(right < gems.length){
            int value = map.getOrDefault(gems[right],0);
            map.put(gems[right], value+1);
            
            while(map.size() == gemSet.size()){
                if(right - left < minLength) {
                    minLength = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
                
                int s = map.get(gems[left]);
                if(s==1) {   
                    map.remove(gems[left]);
                } else {
                    map.put(gems[left], s-1);
                }
                left++;
            }
            right++;
        }
        
        answer[0] += 1;
        answer[1] += 1;

        return answer;
    }
}