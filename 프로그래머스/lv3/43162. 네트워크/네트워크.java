import java.util.*;
class Solution {
    private static boolean[] visited;
    private static int answer;
    
    private void dfs(int v, int[][] computers){
        visited[v-1] = true;
        for(int i=0; i<visited.length; i++){
            if(!visited[i] && computers[v-1][i]==1){
                dfs(i+1, computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!visited[i]) {
                dfs(i+1, computers);
                answer++;
            }
        }
        return answer;
    }
}