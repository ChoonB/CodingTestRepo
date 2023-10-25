class Solution {
    public String solution(String s) {
        String answer = "";
        String[] split = s.toLowerCase().split("");
        boolean tf = true;
        for (String i : split) {
            answer += tf ? i.toUpperCase() : i;
            tf = i.equals(" ") ? true : false;
        }
        return answer;
    }
}