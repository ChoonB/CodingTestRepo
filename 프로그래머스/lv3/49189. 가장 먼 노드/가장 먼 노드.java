import java.util.*;

class Comb{
    private int n; // 노드 번호
    private int d; // 깊이
    
    public Comb(int n, int d){
        this.n = n;
        this.d = d;
    }
    
    public int getD(){
        return d;
    }
    public int getN(){
        return n;
    }
}

class Solution {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    
    private static void putEdge(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
    
    private static int bfs(int v){
        visited[v] = true;
        
        Queue<Comb> q = new LinkedList<>();
        q.add(new Comb(v,0));
        Map<Integer, Integer> map = new HashMap<>();
        int count = map.getOrDefault(0,0);
        map.put(0, count+1);
        
        
        while(!q.isEmpty()){
            Comb tmp = q.poll();
            int tmpN = tmp.getN();
            int tmpD = tmp.getD();
            
            ArrayList<Integer> a = graph.get(tmpN);
            for(int i=0; i<a.size(); i++){ 
                int index = a.get(i);
                if(!visited[index]){
                    int depth = tmpD+1;
                    q.add(new Comb(index, depth));
                    visited[index] = true;
                    int count2 = map.getOrDefault(depth, 0);
                    map.put(depth, count2+1);
                }
            }
        }
        Integer maxKey = Collections.max(map.keySet());
        
        return map.get(maxKey); 
    }
    
    public int solution(int n, int[][] edge) {
        // 0~n까지 graph에 각각의 ArrayList 생성
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        // vertex로 그래프 간선 구현
        for(int[] e : edge){
            putEdge(e[0], e[1]);
        }
        // 방문기록용 boolean 배열
        visited = new boolean[n+1];
        
        int answer = bfs(1);
        return answer;
    }
}