import java.util.*;
class Solution {
    boolean[] visited;
    int count;
    int answer;
    
    public int solution(int k, int[][] dungeons) {
        int len = dungeons.length;
        visited = new boolean[len];
        dfs(dungeons, k);
        
        return answer;
    }
    
    public void dfs(int[][] dungeons, int k){
        int len = dungeons.length;
        for(int i=0; i<len; i++){
            if(!visited[i] && k>=dungeons[i][0]){
                count++;
                answer=Math.max(answer, count);
                visited[i] = true;
                k -= dungeons[i][1];
                dfs(dungeons, k);
                k += dungeons[i][1];
                visited[i] = false;
                count--;
            }
        }
        
        
    }
}