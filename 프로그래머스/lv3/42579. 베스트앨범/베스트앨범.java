import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = plays.length;
        
        // 해시맵 생성
        Map<String, int[]> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            int[] a = map.getOrDefault(genres[i], null);
            if(a==null){
                int[] b = new int[]{plays[i], i, -1};
                map.put(genres[i], b);
            } else {
                int now = plays[i];
                int max1 = plays[a[1]];
                int max2 = -1;
                if(a[2]!=-1){
                    max2 = plays[a[2]];
                }
                
                int[] c = null;
                if(now > max1){
                    c = new int[]{a[0]+now, i, a[1]};
                } else if (now > max2){
                    c = new int[]{a[0]+now, a[1], i};
                } else {
                    c = new int[]{a[0]+now, a[1], a[2]};
                }
                
                map.put(genres[i], c);
            }
            
        }
        
        List<int[]> sortedList = new ArrayList<>(map.values());
        sortedList.sort((a,b) -> Integer.compare(b[0], a[0]));
        
        List<Integer> result = new ArrayList<>();
        
        for(int[] arr : sortedList){
            result.add(arr[1]);
            if(arr[2] != -1) result.add(arr[2]);
        }
        int[] answer = new int[result.size()];
        
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}