import java.util.*;
class Solution {
    private static List<List<Integer>> graph;
    private static boolean[] used;
    
    private static int bfs(String begin, String target, String[] words){
        int depth = 0;
        // 큐에는 (단어의 배열 상 index, 깊이(단계))의 크기 2의 int 배열을 넣는다.
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{words.length, depth});
        used[words.length] = true;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int tmpI = tmp[0];
            int tmpD = tmp[1];
            
            for(int i : graph.get(tmpI)){
                if(!used[i]){
                    if(words[i].equals(target)){
                        return tmpD+1;
                    }
                    used[i] = true;
                    q.add(new int[]{i, tmpD+1});
                }
            }
            
        }
        
        return 0;
        
    } 
    
    private static boolean checkString(String a, String b){
        int difference = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) {
                difference++;
            }
            if (difference > 1) return false;
        }
        if (difference == 1) {
            return true;
            } else {
            return false;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        used = new boolean[words.length+1];
        graph = new ArrayList<>();
        
        // 간선 생성
        for(int i=0; i<words.length; i++){
            graph.add(new ArrayList<>());
            
            for(int j=0; j<words.length; j++){
                if (i==j) continue;
                boolean flag = checkString(words[i], words[j]);
                if (flag) {
                    graph.get(i).add(j);
                }
            }
        }
        graph.add(new ArrayList<>());
        for(int j=0; j<words.length; j++){
                boolean flag = checkString(begin, words[j]);
                if (flag) {
                    graph.get(words.length).add(j);
                }
            }
        
        
        return bfs(begin, target, words);
    }
}