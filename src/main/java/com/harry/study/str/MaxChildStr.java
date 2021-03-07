package com.harry.study.str;

import java.util.HashMap;
import java.util.Map;

/**
 * MaxChildStr
 * 最大不重复子串长度
 * @author harry
 * @date 2021/3/7 6:47 下午
 **/
public class MaxChildStr {

    public static void main(String[] args) {
        String str = "jsagdfjsgfkjsafuwifsjhbcsjbc";
        System.out.println(maxChildStr(str));
    }

    private static int maxChildStr(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int length = str.length();
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>(8);
        while (right < length) {
            Character character = str.charAt(right);
            if (map.containsKey(character)) {
                left = Math.max(map.get(character)+1,left);
            }
            map.put(character,right++);
            max = Math.max(max,right-left);
        }
        return max;
    }

}
