class Solution {
    public String solution(String s) {
        String[] s1 = s.split(" ");
        int[] intArr = new int[s1.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(s1[i]);
        }
        int max = intArr[0];
        int min = intArr[0];

        for (int i : intArr) {
            if (max<i){
                max = i;
            }
            if(min>i){
                min = i;
            }
        }
        String answer = "" + min + " " + max;
        return answer;
    }
}