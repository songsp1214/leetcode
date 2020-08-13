package com.leetcode.problemset;

import java.util.ArrayList;
import java.util.List;

public class LC43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        List<String> list = new ArrayList<>();
        int len2 = num2.length();
        String res = multiply(num1, num2.charAt(len2 - 1));
        StringBuilder s0 = new StringBuilder("0");
        for (int i = len2 - 2; i >= 0; i--) {
            res = add(res, multiply(num1, num2.charAt(i)) + s0.toString());
            s0.append("0");
        }

        return res;
    }

    public String multiply(String num1, char c2) {
        if (num1.length() == 0 || c2 == '0') {
            return "0";
        }
        int n2 = c2 - '0';
        StringBuilder res = new StringBuilder();
        int bit = 0;
        for(int i = num1.length() - 1; i >= 0; i--) {
            int tmp = (num1.charAt(i) - '0') * n2 + bit;
            res.append((char)(tmp % 10 + '0'));
            bit = tmp / 10;
        }
        if (bit > 0) {
            res.append((char)(bit + '0'));
        }

        return res.reverse().toString();
    }

    public String add(String s1, String s2) {
        StringBuilder res = new StringBuilder();
        int i1 = s1.length() - 1, i2 = s2.length() - 1;
        int bit = 0;
        while (i1 >= 0 || i2 >= 0) {
            int tmp;
            if (i1 < 0) {
                tmp = s2.charAt(i2--) + bit - '0';
            } else if (i2 < 0) {
                tmp = s1.charAt(i1--) + bit - '0';
            } else {
                tmp = s1.charAt(i1--) + s2.charAt(i2--) + bit - '0' - '0';
            }
            res.append((char)(tmp % 10 + '0'));
            bit = tmp / 10;
        }
        if (bit > 0) {
            res.append((char)(bit + '0'));
        }

        return res.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(new LC43().multiply("589", '8'));
        System.out.println(new LC43().add("189", "1899"));
        System.out.println(new LC43().multiply("589", "1899"));
    }
}
