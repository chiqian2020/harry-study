package com.harry.study;

import java.util.HashMap;
import java.util.Map;

/**
 * Max
 *
 * @author harry
 * @date 2021/1/12 10:26 上午
 **/
public class MaxNotRepeat {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("jsagdfjsgfkjsafuwifsjhbcsjbc"));
    }

    public static int lengthOfLongestSubstring(String str) {
        int length = str.length();
        int left = 0,right = 0, max = 0;
        Map<String,Integer> map = new HashMap<>(8);
        while (right < length) {
            if (map.containsKey(String.valueOf(str.charAt(right)))) {
                left = Math.max(map.get(String.valueOf(str.charAt(right)))+1,left);
            }
            map.put(String.valueOf(str.charAt(right)),right++);
            max = Math.max(max,right-left);
        }
        return max;
    }

}
