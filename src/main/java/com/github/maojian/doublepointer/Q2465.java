package com.github.maojian.doublepointer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2465. 不同的平均值数目
 */
public class Q2465 {

    public int distinctAverages(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        Set<Integer> sums = new HashSet<>();
        for (int i = 0,j=length-1; i < j; ++i,--j) {
            sums.add(nums[i]+nums[j]);
        }
        return sums.size();
    }

    @Test
    public void test() {
        int[] nums = new int[]{4, 1, 4, 0, 3, 5};
        System.out.println(distinctAverages(nums));
    }
}
