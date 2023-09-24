class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        int[][] memo = new int[size][];
        memo[0] = triangle[0];
        if (size == 1) return memo[0][0];

        for (int i = 1; i < size; i++) {
          memo[i] = new int[triangle[i].length];
            for (int j = 0; j < memo[i].length; j++) {
                if (j==0) {
                memo[i][j] = memo[i-1][j] + triangle[i][j];
                } else if (j == memo[i].length-1) {
                memo[i][j] = memo[i-1][j-1] + triangle[i][j];
                } else {
                memo[i][j] = Math.max(memo[i-1][j-1], memo[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        int answer = 0;
        for (int i : memo[triangle.length-1]) {
            if (i>answer) answer = i;
        }
        
        return answer;
    }
}