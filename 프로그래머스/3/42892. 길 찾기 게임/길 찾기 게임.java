import java.util.*;
class Solution {
    int[][] answer;
    int index;
    
    public class Node implements Comparable<Node>{
        int x;
        int y;
        int value;
        Node left;
        Node right;
        
        // y값이 큰 순서대로 정렬. y가 같으면 x가 작은 순서대로 정렬
        @Override
        public int compareTo(Node other){
            if(this.y == other.y) {
                return this.x - other.x;
            } else {
                return other.y - this.y;
            }
        }
        
        public Node(int x, int y, int value, Node left, Node right){
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    
    public void insert(Node parent, Node child){
        if(parent.x > child.x){
            if(parent.left == null){
                parent.left = child;
            } else {
                insert(parent.left, child);
                }
        } else {
            if(parent.right == null){
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }
    
    
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        
        for(int i=0; i<nodeinfo.length; i++){
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1, null, null);
        }
        Arrays.sort(nodes);
        
        Node root = nodes[0];
        for(int i=1; i<nodes.length; i++){
            insert(root, nodes[i]);
        }
        
        answer = new int[2][nodeinfo.length];
        index = 0;
        preorder(root);
        index = 0;
        postorder(root);

        return answer;
    }
    
    // 전위 순회
    public void preorder(Node root){
        if(root==null) return;
        answer[0][index++] = root.value;
        preorder(root.left);
        preorder(root.right);
    }
    
    // 후위순회
    public void postorder(Node root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        answer[1][index++] = root.value;
    }
}