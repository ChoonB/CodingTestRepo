class Solution {
  public int[] solution(int n, int s) {
    if (n>s) return new int[] {-1};
    int[] result = new int[n];
    int b = 0;

    for (int i = n; i >= 1; i--) {
      int a = s/i;
      s -= a;
      result[b] = a;
      b++;
    }
    return result;
  }
}