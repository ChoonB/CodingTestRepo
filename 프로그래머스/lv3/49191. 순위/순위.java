import java.util.*;
class Solution {
    
    public void floydWarshall(int n, int[][] graph){
        for(int m=1; m<=n; m++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(graph[i][m]==1 && graph[m][j]==1){
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                    if(graph[i][m]==-1 && graph[m][j]==-1){
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }
    }
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] graph = new int[n+1][n+1];
        
        for(int[] r : results){
            int w = r[0];
            int l = r[1];
            graph[w][l] = 1;
            graph[l][w] = -1;
        }
        
        floydWarshall(n,graph);
        
        for(int i=1; i<=n; i++){
            int count = 0;
            for(int j=1; j<=n; j++){
                if(graph[i][j] == 0) count++;
            }
            if(count <= 1) answer++;
        }
        
        return answer;
    }
}