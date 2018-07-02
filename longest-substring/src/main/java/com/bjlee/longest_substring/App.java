package com.bjlee.longest_substring;

public class App {

    public static void main(String[] args) {
        // abcabcbb
        String input = "abcabcbb";

        int len = new Solution().lengthOfLongestSubstring(input);
        System.out.println("length : " + len);
    }
}

