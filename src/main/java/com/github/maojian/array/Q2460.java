package com.github.maojian.array;

import org.junit.Test;

/**
 * 2460. 对数组执行操作
 */
public class Q2460 {
    public int[] applyOperations(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return nums;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 2, 1, 1, 0};
        nums = applyOperations(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
