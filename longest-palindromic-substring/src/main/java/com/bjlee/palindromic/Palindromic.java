package com.bjlee.palindromic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Palindromic {
    private final int maxLength = 1000;
    private String givenString;
    private String lognestStr = "";

    public Palindromic(String givenString) {
        if (givenString.length() < maxLength) {
            throw new IllegalArgumentException("too long given string length.");
        }
        this.givenString = givenString;
    }

    public Palindromic getLognestSubstring() {
        System.out.println("longest sub string bla bla...");

        if (givenString.length() == 1) {
            lognestStr = givenString;
            return this;
        }

        // 가장 긴 문자열 값
        // palindromic 문자열 array
        List<String> palindromicList = new ArrayList<>();
        List<String> allSubList = new ArrayList<>();

        // 스트링을 2글자 이상의 문자열들로 나눈다.
        String subString = "";

        // 주어진 문자열의 모든 문자열을 쪼개 저장한다.
        // 2, 3, 4, 5, 6 ~~ n 까지

        // length 가 2인 경우는 확인만하고 return
        if (givenString.length() == 2) {
            if (givenString.toCharArray()[0] == givenString.toCharArray()[1]) {
                lognestStr = givenString;
                return this;
            } else {
                return this;
            }
        }

        for (int i = 0; i < givenString.length(); i++) {

        }


        Optional<String> longestString = palindromicList.stream().max(Comparator.comparing(String::length));

        lognestStr = longestString.toString();

        return this;
    }

    /**
     * 주어진 문자열이 palindromic 이면 true
     *
     * @param subString
     * @return
     */
    private boolean isPalindromic(String subString) {
        return false;
    }

    @Override
    public String toString() {
        return "Palindromic{" +
                "lognestStr='" + lognestStr + '\'' +
                '}';
    }
}
