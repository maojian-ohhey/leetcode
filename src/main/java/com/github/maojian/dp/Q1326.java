package com.github.maojian.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 1326. 灌溉花园的最少水龙头数目
 * 选择最少的区间数目可以覆盖连续区间[0,n]
 */
public class Q1326 {

    public int minTaps(int n, int[] ranges) {
        int[][] intervals = new int[n + 1][];
        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            intervals[i] = new int[]{start, end};
        }
        // [0,3],[0,5],[1,3],[2,4],[4,4],[5,5]
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            if (dp[start] == Integer.MAX_VALUE) {
                return -1;
            }
            for (int i = start; i <= end; i++) {
                dp[i] = Math.min(dp[i], dp[start] + 1);
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        int n = 5;
        int[] ranges = new int[]{3, 4, 1, 1, 0, 0};
        System.out.println(minTaps(n, ranges));
    }


}
