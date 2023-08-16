import java.util.*;
class Solution {
    static List<List<Node>> graph;
    static int[] leastTime;
    static int n;
    
    static class Node implements Comparable<Node> {
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
    
    static void dijkstra(int index){
        Queue<Node> pq = new PriorityQueue<>();
        
        leastTime = new int[n+1];
        Arrays.fill(leastTime, Integer.MAX_VALUE);
        leastTime[0] = 0;
        leastTime[1] = 0;
        pq.offer(new Node(index, 0));
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int nv = node.vertex;
            int nw = node.weight;
            
            if(nw>leastTime[nv]) continue;
            
            for(Node linkedNode : graph.get(nv)){
                int lv = linkedNode.vertex;
                int lw = linkedNode.weight;
                
                if(nw+lw < leastTime[lv]){
                    leastTime[lv] = nw+lw;
                    pq.offer(new Node(lv, leastTime[lv]));
                }
            }
        }
        
    }
    
    
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        n = N;
        
        // 그래프 생성
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] r : road){
            int start = r[0];
            int end = r[1];
            int time = r[2];
            
            graph.get(start).add(new Node(end, time));
            graph.get(end).add(new Node(start, time));
        }
        
        
        dijkstra(1);
        
        for(int time : leastTime){
            if(time <= K) answer++;
        }
        
        return answer-1;
    }
}