package com.github.maojian.queue;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2558 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->b-a);
        for (int gift:gifts){
            priorityQueue.offer(gift);
        }
        while (k>0){
            k--;
            int x = priorityQueue.poll();
            priorityQueue.offer((int) Math.sqrt(x));
        }
        long result = 0;
        while (!priorityQueue.isEmpty()){
            result+=priorityQueue.poll();
        }
        return result;
    }

    @Test
    public void test(){
        int[] gifts = new int[]{25,64,9,4,100};
        int k = 4;
        System.out.println(pickGifts(gifts,k));
    }

}
