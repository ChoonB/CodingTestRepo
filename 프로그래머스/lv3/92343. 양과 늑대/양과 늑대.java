class Solution {
    int[] inf;
    int[][] edg;
    int maxSheep = 0;
    
    public void dfs(int n, int sc, int wc, boolean[] visited){
        visited[n] = true;
        int len = visited.length;
        if(inf[n]==0){
            sc++;
            maxSheep = Math.max(maxSheep, sc);
        } else{
            wc++;
        }
        if(wc>=sc) return;
        
        for(int[] e : edg){
            if(visited[e[0]] && !visited[e[1]]){
                boolean[] nextVisited = new boolean[len];
                for(int i=0; i<len; i++){
                    nextVisited[i] = visited[i];
                }
                
                dfs(e[1], sc, wc, nextVisited);
            }
            
        }
    }
    
    
    public int solution(int[] info, int[][] edges) {
        inf = info;
        edg = edges;
        
        boolean[] visited = new boolean[info.length];
        dfs(0,0,0,visited);
        
        return maxSheep;
    }
}