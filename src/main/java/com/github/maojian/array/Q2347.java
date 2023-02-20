package com.github.maojian.array;

import org.junit.Test;

/**
 * 2347. 最好的扑克手牌
 */
public class Q2347 {

    public String bestHand(int[] ranks, char[] suits) {
        int[][] all = new int[13][4];
        for (int i = 0; i < 5; i++) {
            all[ranks[i] - 1][suits[i] - 'a']++;
        }
        // 判断是否同花
        int sameCount;
        for (int i = 0; i < 4; i++) {
            sameCount = 0;
            for (int j = 0; j < 13; j++) {
                sameCount += all[j][i];
            }
            if (sameCount == 5) return "Flush";
        }

        int maxCount = 0;
        for (int i = 0; i < 13; i++) {
            sameCount = 0;
            for (int j = 0; j < 4; j++) {
                sameCount += all[i][j];
            }
            maxCount = Math.max(maxCount, sameCount);
        }
        if (maxCount > 2) return "Three of a Kind";
        if (maxCount > 1) return "Pair";
        return "High Card";
    }

    @Test
    public void test() {
        int[] ranks = new int[]{13, 2, 3, 1, 9};
        char[] suits = new char[]{'a', 'a', 'a', 'a', 'a'};
        System.out.println(bestHand(ranks, suits));

        ranks = new int[]{4, 4, 2, 4, 4};
        suits = new char[]{'d', 'a', 'a', 'b', 'c'};
        System.out.println(bestHand(ranks, suits));

        ranks = new int[]{12, 12, 12, 9, 9};
        suits = new char[]{'d', 'a', 'a', 'b', 'c'};
        System.out.println(bestHand(ranks, suits));
    }
}
