package com.bjlee.longest_substring;

public class App {

    public static void main(String[] args) {
        App app = new App();

        String input = "au";

        int len = new Solution().lengthOfLongestSubstring(input);
        System.out.println("length : " + len);
    }
}

class Solution {
    /*
     * 같은 문자의 반복없이 가장 긴 문자열 찾기
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }

        // 같은 문자 확인, 같으면 length 는 1로 변경
        // 다음 문자열
        String subStr = "";

        int count = 0;
        int len;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            // 문자열이 있으면 전체 문자열에서 반복되는 문자열이 있는지 찾는다.
            int idx = subStr.indexOf(curChar);
            if (idx > -1) {
                len = subStr.length();
                if (len > count) {
                    count = len;
                }

                // 같은 문자 나오면 저장
                // idx 만큼 이동저장
                subStr = subStr.substring(idx + 1, len);
            }
            subStr = subStr.concat(String.valueOf(curChar));
        }

        return subStr.length() > count ? subStr.length() : count;
    }
}