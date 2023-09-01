import java.util.*;
public class Road {
    int x;
    int y;
    int direction;
    int cost;
    
    Road(int x, int y, int direction, int cost) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.cost = cost;
    }
}

class Solution {
    boolean[][][] visited;
    int[] xMove = {1,0,-1,0};
    int[] yMove = {0,1,0,-1};
    final int st = 100;
    final int cn = 500;
    
    public int bfs(int[][] board){
        int n = board.length;
        int[][] map = board;
        int min = Integer.MAX_VALUE;
        
        Queue<Road> q = new ArrayDeque<>();
        
        q.offer(new Road(0,0,-1,0));
        for(int i=0; i<4; i++){
            visited[0][0][i] = true;
        }
        while(!q.isEmpty()){
            Road road = q.poll();
            int tmpX = road.x;
            int tmpY = road.y;
            int tmpD = road.direction;
            int tmpC = road.cost;
            
            if(tmpX==n-1 && tmpY==n-1){
                min = Math.min(min,tmpC);
            }
            
            for(int i=0; i<4; i++){
                int newX = tmpX + xMove[i];
                int newY = tmpY + yMove[i];
                if(newX<0 || newY<0 || newX>=n || newY>=n || board[newX][newY]==1) continue;
                
                int newC = tmpC;
                if(tmpD==-1 || tmpD == i){
                    newC += st;
                } else {
                    newC += cn + st;
                }
                
                if(!visited[newX][newY][i] || map[newX][newY] >= newC){
                    visited[newX][newY][i] = true;
                    map[newX][newY] = newC;
                    q.offer(new Road(newX, newY, i, newC));
                }
                
                
            }
            
        }
        return min;
    }
    
    public int solution(int[][] board) {
        visited = new boolean[board.length][board.length][4];
        return bfs(board);
    }
}