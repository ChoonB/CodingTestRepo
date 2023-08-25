import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = plays.length;
        
        // 해시맵 생성
        Map<String, int[]> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            // 장르를 키로 넣어서 있으면 value 
            int[] a = map.getOrDefault(genres[i], null);
            if(a==null){
                // 장르의 누적 스트리밍수, 최다 스트리밍 노래 번호, 2번째 스트리밍 노래 번호
                int[] b = new int[]{plays[i], i, -1};
                map.put(genres[i], b);
            } else {
                // 현재 순회중인 노래의 스트리밍 수
                int now = plays[i];
                // 이 장르의 현재까지 최다 스트리밍 수
                int max1 = plays[a[1]];
                // 이 장르의 현재까지 2번째 많은 스트리밍 수
                int max2 = -1;
                if(a[2]!=-1){
                    max2 = plays[a[2]];
                }
                
                int[] c = new int[3];
                c[0] = a[0] + now;
                // 현재 순회중인 노래가 최다 스트리밍일 때
                if(now > max1){
                    c[1] = i;
                    c[2] = a[1];
                // 두 번째 최다 스트리밍일 때
                } else if (now > max2){
                    c[1] = a[1];
                    c[2] = i;
                } else {
                    // 그 이하일 때
                    c[1] = a[1];
                    c[2] = a[2];
                }
                // key로 장르제목, value로 int[]를 삽입한다.
                map.put(genres[i], c);
            }
            
        }
        
        // 해시맵을 누적 스트리밍(int[]의 0번째 인덱스)을 기준으로 내림차순 정렬한다.
        List<int[]> sortedList = new ArrayList<>(map.values());
        sortedList.sort((a,b) -> Integer.compare(b[0], a[0]));
        
        List<Integer> result = new ArrayList<>();
        
        // 정렬된 리스트를 순회하면서 1번값과 2번값(있으면)을 넣는다.
        for(int[] arr : sortedList){
            result.add(arr[1]);
            if(arr[2] != -1) result.add(arr[2]);
        }
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}