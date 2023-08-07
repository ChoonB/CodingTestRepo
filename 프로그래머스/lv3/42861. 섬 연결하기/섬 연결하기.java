import java.util.*;

class Solution {
    
    static int[] root;
    static int answer;
    static int count;
    
    public void union(int x, int y, int cost){
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX == rootY) return;
        root[rootY] = rootX;
        
        answer += cost;
        count++;
    }
    
    public int find(int x){
        if(root[x] != x){
            root[x] = find(root[x]);
        }
        return root[x];
    }
    
    public int solution(int n, int[][] costs) {
        if(n<=1) return 0;
        
        answer = 0;
        root = new int[n];
        count = 0;
        
        // unionfind 초기화
        for(int i=0; i<n; i++){
            root[i] = i;
        }
        
        // 크루스칼 적용하기 위해 sort
        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));
        
        // 크루스칼로 MST 구현
        for(int i=0; i<costs.length; i++){
            if(count >= n-1) break;
            int x = costs[i][0];
            int y = costs[i][1];
            int cost = costs[i][2];
            union(x,y,cost);
        }
        
        return answer;
    }
}
