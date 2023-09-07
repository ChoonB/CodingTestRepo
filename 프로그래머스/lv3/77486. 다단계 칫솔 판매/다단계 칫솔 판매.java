import java.util.*;
class Node {
    String name;
    Node parent;
    int money = 0;
    
    Node(String name) {
        this.name = name;
    }
}

class Solution {
    // 정산
    public void pay(Node node, int rev){    
        int payment = rev / 10;
        
        node.money += rev - payment;
        if(node.parent == null || payment == 0) return;
        pay(node.parent, payment);
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int m = seller.length;
        
        List<Node> nodeList = new ArrayList<>();
        Map<String, Integer> nameOrder = new HashMap<>();
        
        // nodeList에 노드 생성해서 삽입
        for(int i=0; i<n; i++){
            Node node = new Node(enroll[i]);
            nameOrder.put(enroll[i], i);
            
            if(!referral[i].equals("-")){
                int p = nameOrder.get(referral[i]);
                Node parent = nodeList.get(p);
                node.parent = parent;
            }
            
            nodeList.add(node);
        }
        
        // 판매 금액 넣기
        for(int i=0; i<m; i++){
            int index = nameOrder.get(seller[i]);
            Node node = nodeList.get(index);
            int revenue = amount[i] * 100;           
            pay(node, revenue);
        
        }
        
        int[] answer = new int[n];
        
        // 출력값반환
        for(int i=0; i<n; i++){
            Node node = nodeList.get(i);
            answer[i] = node.money;
        }
        
        
        
        return answer;
    }
}