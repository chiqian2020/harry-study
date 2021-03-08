package com.harry.study.str;

import java.util.ArrayList;
import java.util.List;

/**
 * PartitionStr
 * 输出回文：左右读都是一样的
 * @author harry
 * @date 2021/3/7 8:30 下午
 **/
public class PartitionStr {

    public static void main(String[] args) {
        String str = "aab";
        System.out.println(partition(str));
    }

    private static List<List<String>> partition(String str) {
        List<List<String>> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (isPalindrome(str,0,i))  {
                String left = str.substring(0,i+1);
                for (List<String> rightList : partition(str.substring(i + 1))) {
                    List<String> sub = new ArrayList<>();
                    sub.add(left);
                    sub.addAll(rightList);
                    res.add(sub);
                }
            }
        }
        return res;
    }

    /**
     * 判断是否回文
     * @param s 子串
     * @param l 左边界
     * @param r 右边界
     * @return
     */
    private static boolean isPalindrome(String s,int l,int r) {
        while (l<r) {
            if (s.charAt(l)!=s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
