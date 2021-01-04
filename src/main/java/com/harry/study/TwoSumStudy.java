package com.harry.study;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSumStudy
 * 返回数组中两数相加为固定值的序号
 * @author harry
 * @date 2021/1/4 3:12 下午
 **/
public class TwoSumStudy {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int sum = 22;
        int[] result = sum1(nums,sum);
        System.out.println(result[0]+"-----"+result[1]);
        result = sum2(nums,sum);
        System.out.println(result[0]+"-----"+result[1]);
    }

    public static int[] sum1(int[] nums,int sum) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (nums[j] == sum - nums[i]) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    public static int[] sum2(int[] nums,int sum) {
        Map<Integer,Integer> map = new HashMap<>(8);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(sum-nums[i])) {
                return new int[]{map.get(sum-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

}
