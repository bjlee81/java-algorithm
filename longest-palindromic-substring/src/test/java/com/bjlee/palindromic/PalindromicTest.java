package com.bjlee.palindromic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Random;

class PalindromicTest {
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    Palindromic palindromic;

    @BeforeEach
    void setUp() {
//        palindromic = new Palindromic(generateRandomString());
        palindromic = new Palindromic("abcdeaba");
    }

    private String generateRandomString() {
//        byte[] array = new byte[1000];
//        new Random().nextBytes(array);
//        String generatedString = new String(array, Charset.forName("UTF-8"));
//        return generatedString;

        int len = 20;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(new SecureRandom().nextInt(AB.length())));
        return sb.toString();
    }

    @Test
    void palindromicTest() {
        System.out.println(palindromic.getLognestSubstring().toString());

    }

}
