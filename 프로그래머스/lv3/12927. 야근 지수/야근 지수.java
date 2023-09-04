import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public long solution(int n, int[] works) {
    
    int sum = 0;
    for (int work : works) {
      sum += work;
    }
    if (n>=sum) return 0;

    PriorityQueue<Integer> pq = IntStream.of(works)
        .boxed()
        .collect(Collectors.toCollection(() -> new PriorityQueue<Integer>(Comparator.reverseOrder())));

    for (int i = 0; i < n; i++) {
      Integer a = pq.poll();
      pq.offer(a-1);
    }

    long answer = 0;
    for (Integer c : pq) {
      answer += c*c;
    }
    return answer;

    }
}