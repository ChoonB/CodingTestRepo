import java.util.*;
class Solution {
    static int INF;

    public int[][] floydWarshall(int[][] graph, int n){
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = graph[i][j];
            }
        }

        for(int m=0; m<n; m++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dist[i][j] > dist[i][m] + dist[m][j]){
                        dist[i][j] = dist[i][m] + dist[m][j];
                    }
                }
            }
        }
        return dist;
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        INF = 100000*n;
        int answer = INF;

        int[][] graph = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for(int[] fare : fares){
            graph[fare[0]-1][fare[1]-1] = fare[2];
            graph[fare[1]-1][fare[0]-1] = fare[2];
        }
        int[][] dist = floydWarshall(graph, n);

        for(int i=0; i<n; i++){
            answer = Math.min(answer, dist[a-1][i] + dist[b-1][i] + dist[i][s-1]);
        }

        return answer;
    }
}