import java.util.*;
class Solution {
    List<List<Integer>> graph;
    boolean[] visited;
    int count;
    
    public void dfs(int x){
        visited[x] = true;
        count++;
        
        for(int y : graph.get(x)){
            if(!visited[y]) dfs(y);
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = 100;
        int len = wires.length;
        
        graph = new ArrayList<>();
        visited = new boolean[n+1];
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<len; i++){
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        
        for(int i=0; i<len; i++){
            Integer s = wires[i][0];
            Integer e = wires[i][1];
            
            graph.get(s).remove(e);
            graph.get(e).remove(s);
            
            Arrays.fill(visited, false);
            List<Integer> cList = new ArrayList<>();
            
            for(int j=1; j<=n; j++){
                if(!visited[j]){
                    count = 0;
                    dfs(j);
                    cList.add(count);
                }
            }
            
            int a = Math.abs(cList.get(0) - cList.get(1));
            answer = Math.min(answer,a);
            
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        return answer;
    }
}