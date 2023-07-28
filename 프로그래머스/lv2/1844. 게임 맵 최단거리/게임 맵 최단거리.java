import java.util.*;

class Solution {
    boolean[][] visited;
    int[] xMove = {1,0,-1,0};
    int[] yMove = {0,1,0,-1};
    
    public int bfs(int x, int y, int n, int m, int[][] maps){
        visited[x][y] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,0});
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int tmpX = tmp[0];
            int tmpY = tmp[1];
            int tmpDepth = tmp[2];
            
            if (tmpX == n-1 && tmpY == m-1) {
                return tmpDepth+1;
            }
            
            for(int i=0; i<4; i++){
                int newX = tmpX+xMove[i];
                int newY = tmpY+yMove[i];
                if(newX<0 || newY<0 || newX>=n || newY>=m) continue;
                
                if(visited[newX][newY] || maps[newX][newY]==0) continue;
                    int[] newTmp = {tmpX+xMove[i], tmpY+yMove[i], tmpDepth+1};
                
                q.offer(newTmp);
                visited[newX][newY] = true;
            }
            
        }
        
        return -1;
        
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];
        
        
        return bfs(0,0,n,m,maps);
    }
}
