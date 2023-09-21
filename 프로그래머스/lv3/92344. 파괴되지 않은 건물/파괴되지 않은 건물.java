import java.util.*;
// [type, r1, c1, r2, c2, degree]
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] ws = new int[n+1][m+1];
        
        // 누적합용 새 배열 skill에서 뽑아놓기
        for(int[] sk : skill){
            int r1=sk[1], c1=sk[2], r2=sk[3], c2=sk[4];
            int degree = sk[5];
            if(sk[0]==1) degree *= -1;
            
            ws[r1][c1] += degree;
            ws[r1][c2+1] -= degree;
            ws[r2+1][c1] -= degree;
            ws[r2+1][c2+1] += degree;
        }
        
        // 좌->우로 누적합
        for(int i=0; i<=n; i++){
            for(int j=0; j<m; j++){
                ws[i][j+1] += ws[i][j];
            }
        }
        
        // 위->아래로 누적합
        for(int j=0; j<=m; j++){
            for(int i=0; i<n; i++){
                ws[i+1][j] += ws[i][j];
            }
        }
        
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]+ws[i][j]>=1) answer++;
            }
        }
        
        return answer;
    }
}