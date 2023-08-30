import java.util.*;
class Solution {
    static class Node{
        Map<Character, Node> child = new HashMap<>();
        boolean isEnd;
    }
    
    class Trie{
        Node rootNode;
        
        Trie(){
            rootNode = new Node();
        }
        
        boolean insert(String str){
            Node node = this.rootNode;
            
            for(int i=0; i<str.length(); i++){
                if(node.isEnd) return false;
                
                char c = str.charAt(i);
                node = node.child.computeIfAbsent(c,k -> new Node());
            }
            node.isEnd = true;
            return true;
        }
        
    }
    
    public boolean solution(String[] phone_book) {
        Trie trie = new Trie();
        Arrays.sort(phone_book, (a,b) -> a.length() - b.length());
        
        for(String p : phone_book){
            boolean flag = trie.insert(p);
            if (!flag) return false;
        }
        return true;
    }
}