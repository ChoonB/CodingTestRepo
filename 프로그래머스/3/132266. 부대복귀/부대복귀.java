import java.util.*;
class Solution {
    int[] distance;
    List<List<Node>> graph;
    final int max = 100000;
    int N;
    
    
    public class Node implements Comparable<Node> {
        int v;
        int w;
        
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node other){
            return Integer.compare(this.w, other.w);
        }
    }
    
    public void dijkstra(int index){
        Queue<Node> pq = new PriorityQueue<>();
        distance = new int[N];
        Arrays.fill(distance, max);
        distance[index] = 0;
        pq.offer(new Node(index, 0));
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int nv = node.v;
            int nw = node.w;
            
            if (nw > distance[nv]) continue;
            
            for (Node linked : graph.get(nv)){
                int lv = linked.v;
                int lw = linked.w;
                if(nw+lw < distance[lv]){
                    distance[lv] = nw+lw;
                    pq.offer(new Node(lv, distance[lv]));
                }
            }
        }
    }
    
    
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        N = n+1;
        
        graph = new ArrayList<>();
        for(int i=0; i<N; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] road : roads){
            graph.get(road[0]).add(new Node(road[1],1));
            graph.get(road[1]).add(new Node(road[0],1));
        }
        
        dijkstra(destination);
        
        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++){
            int ans = distance[sources[i]];
            if(ans==max) answer[i] = -1;
            else answer[i] = ans;
        }
        
        
        return answer;
    }
}