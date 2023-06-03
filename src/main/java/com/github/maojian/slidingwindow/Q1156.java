package com.github.maojian.slidingwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 1156. 单字符重复子串的最大长度
 */
public class Q1156 {

    public int maxRepOpt1(String text) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < text.length(); ) {
            // 找出当前连续子字符串[i,j]
            int j = i;
            while (j < text.length() && text.charAt(j) == text.charAt(i)) {
                j++;
            }
            int curInt = j - i;
            if (curInt < count.getOrDefault(text.charAt(i), 0) && (j < text.length() || i > 0)) {
                res = Math.max(res, curInt + 1);
            }
            int k = j + 1;
            while (k < text.length() && text.charAt(k) == text.charAt(i)) {
                k++;
            }
            res = Math.max(res, Math.min(k - i, count.getOrDefault(text.charAt(i), 0)));
            i = j;
        }

        return res;
    }

    @Test
    public void test() {
        String text = "ababa";
        System.out.println(maxRepOpt1(text));
    }
}
