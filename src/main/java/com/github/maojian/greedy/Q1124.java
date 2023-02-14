package com.github.maojian.greedy;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1124 {
    public int longestWPI(int[] hours) {
        int length = hours.length;
        int[] s = new int[length + 1];
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(0);
        for (int i = 1; i <= length; i++) {
            s[i] = s[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (s[stk.peek()] > s[i]) {
                stk.push(i);
            }
        }
        return 0;
    }

    @Test
    public void test() {
        int[] hours = new int[]{9, 9, 6, 0, 6, 6, 9};
        System.out.println(longestWPI(hours));
    }
}
