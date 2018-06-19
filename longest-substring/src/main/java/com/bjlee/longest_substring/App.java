package com.bjlee.longest_substring;

public class App {

    public static void main(String[] args) {
        App app = new App();

        // abcabcbb
        String input = "abcabcbb";

        int len = new Solution().lengthOfLongestSubstring(input);
        System.out.println(len);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = s.length();
        String maxStr = null;
        char[] sArray = s.toCharArray();
        String longStr = String.valueOf(sArray[0]);
        StringBuilder stringBuilder = new StringBuilder(longStr);
        for (int i = 1; i < s.length(); i++) {
            // substring 값이 s에 있으면 max str으로 저장
            char curChar = s.charAt(i);
            if (longStr. == curChar) {
                continue;
            }

            stringBuilder.append(curChar);
        }
        return 0;
    }
}