class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        for(int i=0;i<4;i++){
            key = rotate(key);
            int n = lock.length-1;
            for(int x=-n;x<n; x++){
                for(int y=-n;y<n; y++){
                    if(isCorrect(key,lock,x,y)) return true;
                }
            }
        }
        return false;
    }
    
    int[][] rotate(int[][] key){
        int l = key.length;
        int[][] result = new int[l][l];
        for(int i=0;i<l;i++){
            for(int j=0;j<l;j++){
                result[i][j] = key[key.length-1-j][i];
            }
        }
        return result;
    }
    
    boolean isCorrect(int[][] key, int[][] lock, int x, int y){
        int m = lock.length;
        int n = key.length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i+x<0 || i+x>=n || j+y<0 || j+y>=n){
                    if(lock[i][j]==0) return false;
                }else{
                    if(lock[i][j] == key[i+x][j+y]) return false;   
                }
            }
        }
        return true;
    }
} 