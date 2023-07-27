import java.util.*;
class Solution {
    boolean[] visited;
    List<String> routes;
    
    public void dfs(String start, String route, int count, String[][] tickets){
        if(count == tickets.length){
            routes.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && start.equals(tickets[i][0])){
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], count+1, tickets);
                visited[i] = false;
            }
        }
        
    }
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        routes = new ArrayList<>();
        dfs("ICN", "ICN", 0, tickets);
        
        Collections.sort(routes);
        String[] answer = routes.get(0).split(" ");
        return answer;
    }
}