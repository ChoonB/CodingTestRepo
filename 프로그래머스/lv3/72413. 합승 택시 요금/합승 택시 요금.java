import java.util.*;
class Solution {
    static List<List<Node>> graph;
    
    class Node implements Comparable<Node> {
        int vertex;
        int weight;
        
        Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node other){
            return Integer.compare(this.weight, other.weight);
        }
        
    }
    
    public int[] dijkstra(int index, int[] cheapFares){
        Queue<Node> pq = new PriorityQueue<>();
        Arrays.fill(cheapFares, Integer.MAX_VALUE);
        cheapFares[index] = 0;
        Node startNode = new Node(index,0);
        pq.offer(startNode);
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int nv = node.vertex;
            int nw = node.weight;
            
            if(nw>cheapFares[nv]) continue;
            for(Node linkedNode : graph.get(nv)){
                int lv = linkedNode.vertex;
                int lw = linkedNode.weight;
                
                if(lw+nw < cheapFares[lv]){
                    cheapFares[lv] = lw+nw;
                    Node cheapNode = new Node(lv, cheapFares[lv]);
                    pq.offer(cheapNode);
                }
                
            }
            
        }
        return cheapFares;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        // graph 초기화
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] fare : fares){
            int start = fare[0];
            int end = fare[1];
            int cost = fare[2];
            
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }
        
        int[] startA = new int[n+1];
        int[] startB = new int[n+1];
        int[] startS = new int[n+1];
        
        
        startA = dijkstra(a, startA);
        startB = dijkstra(b, startB);
        startS = dijkstra(s, startS);
        
        
        
        for(int i = 1; i <= n ; i ++) {
            answer = Math.min(answer, startA[i] + startB[i] + startS[i]);
        }
        return answer;
    }
}