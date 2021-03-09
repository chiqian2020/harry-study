package com.harry.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * MaxSlidingWindow
 *
 * @author harry
 * @date 2021/3/9 8:48 下午
 **/
public class MaxSlidingWindow {

    public static void main(String[] args) {
        Integer[] array = {1,2,3,3,1,5,7,2,1};
        System.out.println(maxSlidingWindow(array,3));
    }

    public static List<Integer> maxSlidingWindow(Integer[] nums, int k) {
        if (nums == null || nums.length < k) {
            return Arrays.asList(nums);
        }
        // 结果数组
        List<Integer> result = new ArrayList<>(nums.length-k+1);
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result.add(nums[queue.peek()]);
            }
        }
        return result;
    }

}
