import java.util.*;

class Solution {
    private static boolean isMatch(String userId, String bannedId) {
        if(userId.length() != bannedId.length()) return false;
        
        for(int i=0; i<userId.length(); i++){
            if(bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) return false;
        }
        return true;
    }
    
    private static void findComb(List<List<String>> possible, int index, Set<String> current, Set<Set<String>> result){
        if(index == possible.size()){
            result.add(new HashSet<>(current));
            return;
        }
        for(String user : possible.get(index)){
            if(!current.contains(user)){
                current.add(user);
                findComb(possible, index+1, current, result);
                current.remove(user);
            }
        }
    }
    
    
    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> possible = new ArrayList<>();
        
        for(String banned : banned_id){
            List<String> match = new ArrayList<>();
            
            for (String user : user_id){
                if(isMatch(user, banned)) match.add(user);
            }
            possible.add(match);
        }
        
        Set<Set<String>> result = new HashSet<>();
        findComb(possible, 0, new HashSet<>(), result);
    
        return result.size();
    }
}