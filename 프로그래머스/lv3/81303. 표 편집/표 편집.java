import java.util.*;
class Solution {
        
    class Node {
        boolean deleted;
        Node prev;
        Node next;
        
    }
    
    public String solution(int n, int k, String[] cmd) {
        
        Node[] nodes = new Node[n];
        Deque<Node> stack = new ArrayDeque<>();
        
        
        for(int i=0; i<n; i++){
            nodes[i] = new Node();
        }
        for(int i=1; i<n; i++){
            nodes[i].prev = nodes[i-1];
            nodes[i-1].next = nodes[i];
        }
        
        Node now = nodes[k];
        Node up;
        Node down;
        int tmp;
        
        for(String str : cmd){
            char c = str.charAt(0);
            switch(c) {
                case 'U' :
                    tmp = Integer.parseInt(str.substring(2));
                    for(int i=0; i<tmp; i++){
                        now = now.prev;
                    }
                    break;
                case 'D' :
                    tmp = Integer.parseInt(str.substring(2));
                    for(int i=0; i<tmp; i++){
                        now = now.next;
                    }
                    break;
                case 'C' :
                    now.deleted = true;
                    stack.push(now);
                    up = now.prev;
                    down = now.next;
                    
                    if(up != null){
                        up.next = down;
                    }
                    
                    if(down != null){
                        down.prev = up;
                        now = down;
                    } else {
                        now = up;
                    }
                    break;
                case 'Z' :
                    Node rev = stack.pop();
                    up = rev.prev;
                    down = rev.next;
                    
                    rev.deleted = false;
                    if(up != null){
                        up.next = rev;
                    }
                    if(down != null){
                        down.prev = rev;
                    }
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++){
            if(nodes[i].deleted){
                sb.append("X");
            } else {
                sb.append("O");
            }
        }
        
        return sb.toString();
    }
    
}

