package com.leetcode.problemset;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class LC557 {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            Deque<Character> deque = new LinkedList<>();
            while ((i < len) && (s.charAt(i) != ' ')) {
                deque.offerLast(s.charAt(i));
                i++;
            }
            while (!deque.isEmpty()) {
                res.append(deque.peekLast());
            }
            if ((i < len) && (s.charAt(i) == ' ')) {
                res.append(' ');
            }
        }

        return res.toString();
    }
}
