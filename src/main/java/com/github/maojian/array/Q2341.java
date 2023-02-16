package com.github.maojian.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * 数组能形成多少数对
 */
public class Q2341 {
    public int[] numberOfPairs(int[] nums) {
        int[] rtn = new int[2];
        int[] arr = new int[101];
        for (int num : nums) {
            arr[num]++;
        }
        int pair = 0, alone = 0;
        for (int i = 0; i < arr.length; i++) {
            pair += arr[i] / 2;
            alone += arr[i] % 2;
        }
        rtn[0] = pair;
        rtn[1] = alone;
        return rtn;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 2, 1, 3, 2, 2};
        int[] rtn = new int[]{3, 1};
        Assert.assertArrayEquals(numberOfPairs(nums), rtn);
    }
}
