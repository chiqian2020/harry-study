package com.harry.study.str;

/**
 * MaxLengthPrefix
 * 字符串数组中最长前缀
 * @author harry
 * @date 2021/3/6 11:05 下午
 **/
public class MaxLengthPrefix {

    public static void main(String[] args) {
        String[] strs = {"shjdjsh","shjdj","shjduiyu","shjuyo"};

        System.out.println(maxPrefix(strs));
    }

    private static String maxPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //假定最长前缀是第一个
        String max = strs[0];
        String temp = "";
        //从第二个进行比较
        int index = 1;
        while (index < strs.length) {
            int tempLength = max.length();
            int l2 = strs[index].length();
            int size = tempLength < l2 ? tempLength:l2;
            for (int i = 0; i < size; i++) {
                if (max.charAt(i) != strs[index].charAt(i)) {
                    break;
                }
                temp += max.charAt(i);
            }
            index++;
            max = temp;
            temp = "";
        }
        return max;
    }


}
