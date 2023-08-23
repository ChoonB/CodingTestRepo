class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int stIdx = 0;  // stations 배열의 기지국 인덱스
        int sl = stations.length;
        int apt = 1; // while문 안에서 순회중인 아파트 번호
        
        while(apt<=n){
            // 현재 아파트가 기존 기지국 커버 범위 안일 때
            if(stIdx<sl && apt >= stations[stIdx]-w){
                apt = stations[stIdx]+w+1;
                stIdx++;
            } else {
                // 기지국 커버 범위 밖이면 apt+w에 기지국을 설치하고 그 범위는 apt+2w까지 간다.
                answer++;
                apt += 2*w+1;
            }
        }
        return answer;
    }
}