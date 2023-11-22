import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int first = 9 * 60;
        int last = 0;
        int sum = 0;
        
        for(String time : timetable) {
            int convertedTime = Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3));
            pq.add(convertedTime);
        }
        
        for(int i=0; i<n; i++){
            sum = 0;
            while(!pq.isEmpty()){
                int cur = pq.peek();
                if(cur<=first && sum < m){
                    pq.poll();
                    sum++;
                } else {
                    break;
                }
                last = cur - 1;
            }
            first += t;
        }
        
        if(sum < m) last = first - t;
        
        String hour = String.format("%02d", last/60);
        String min = String.format("%02d", last%60);
        String answer = hour + ":" + min;
        
        return answer;
    }
}