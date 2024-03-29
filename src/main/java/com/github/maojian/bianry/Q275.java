package com.github.maojian.bianry;

import org.junit.Test;

public class Q275 {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }

    @Test
    public void test(){
        int[] citations = new int[]{0,1,3,5,6};
        System.out.println(hIndex(citations));
    }
}
