import java.util.*;

class Solution {
  static int num;
  static int min = -1;
  static boolean[] visit;
  static int N;

  public int solution(int n, int[] weak, int[] dist) {
    N = n;
    num = weak.length;
    visit = new boolean[num];

    Arrays.sort(dist);

    DFS(dist.length - 1, 0, 1, weak, dist);
    return min;
  }

  static void DFS(int start, int count, int friends, int[] weak, int[] dist) {
    if(count == num) { 
      friends--;
      min = (min == -1) ? friends : Math.min(friends, min);
      return;
    }

    List<Integer> back = new ArrayList<>();

    if(start < 0) return;

    for(int i=0;i<num;i++) {
      if(visit[i]) continue;

      back.add(i);
      visit[i] = true;
      count++;

      int dis = dist[start];
      int temp = 1; 
      int idx = i;
      while(dis > 0 && count < num) { 
        if(visit[(idx + 1) % num]) break;

        int d = weak[(idx + 1) % num] - weak[idx];
        if(d < 0) d += N;

        dis -= d;

        if(dis >= 0) {
          temp++;
          count++;

          idx = (idx + 1) % num;
          back.add(idx);
          visit[idx] = true;
        }
      }

      DFS(start - 1, count, friends + 1, weak, dist);
      
      count -= temp;
      for(int b : back){
        visit[b] = false;
      }
      
      back.clear();
    }
  }
}