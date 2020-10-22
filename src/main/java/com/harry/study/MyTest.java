package com.harry.study;

import java.util.HashSet;
import java.util.Set;

/**
 * MyTest
 *
 * @author harry
 * @date 2020/10/22 1:54 下午
 **/
public class MyTest {

    public int[] numsSameConsecDiff(int N, int K) {
        Set<Integer> set = new HashSet<>();

        if (N == 1) {
            set.add(0);
        }

        for (int i = 1; i <= 9; i++) {
            helper(set, i, K, N, 1);
        }

        int[] result = new int[set.size()];
        int index = 0;
        for (int ele : set) {
            result[index++] = ele;
        }

        return result;
    }

    private void helper(Set<Integer> result, int cur, int K, int N, int len) {
        if (len == N) {
            result.add(cur);
            return;
        }

        int lastDigit = cur % 10;

        if (lastDigit + K < 10) {
            helper(result, cur * 10 + lastDigit + K, K, N, len + 1);
        }

        if (lastDigit - K >= 0) {
            helper(result, cur * 10 + lastDigit - K, K, N, len + 1);
        }
    }

    public static void main(String[] args) {
        MyTest my =  new MyTest();
        int[] s = my.numsSameConsecDiff(3,2);
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]+"  ");
        }
    }

}
