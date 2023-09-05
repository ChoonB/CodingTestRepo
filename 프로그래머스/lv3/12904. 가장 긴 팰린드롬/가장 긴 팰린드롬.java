class Solution {
    private boolean isP(int left, int right, String s){
        
        while(left<right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    
    public int solution(String s) {
        int answer = 1;
        if(s.length() == 1) return 1;
        
        for(int i=0; i<s.length()-1; i++){
            for(int j=s.length()-1; j>=i; j--){
                if(isP(i,j,s)) answer = Math.max(answer, j-i+1);
            }
        }

        return answer;
    }
}