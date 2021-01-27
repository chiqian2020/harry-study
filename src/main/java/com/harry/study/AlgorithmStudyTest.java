package com.harry.study;

import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 *
 * 死磕算法
 *
 * @author harry
 * @date 2021/1/13 10:54 上午
 **/
public class AlgorithmStudyTest {

    /**
     * @Author harry
     * @Description 求字符串数组最长前缀
     * @Date 2021/1/28 0028
     * @Param []
     * @return void
     **/
    @Test
    public void getMaxLongPrefix() {
        String[] array = {"flwe","flw","flwwe","flw"};
        String str = array[0];
        String str2 = "";
        int index = 1;
        while(index < array.length){
            for(int i=0; i < (str.length() < array[index].length()? str.length():array[index].length());
                i++){
                if(str.charAt(i) != array[index].charAt(i)){
                    break;
                }
                str2 += str.charAt(i);
            }
            str = str2;
            str2 = "";
            index++;
        }
        System.out.println(str);
    }

    //求最大长度不重复字串
    @Test
    public void getMaxNotRepeatLength() {
        String str = "jsagdfjsgfkjsafuwifsjhbcsjbc";
        int length = str.length();
        int left = 0,right = 0,max = 0;
        Map<Character,Integer> map = new HashMap<>();
        while (right < length) {
            Character c = str.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(map.get(c)+1,left);
            }
            map.put(c,right++);
            max = Math.max(max,right-left);
        }
        System.out.println(max);
    }

    //两个排序数组合并
    @Test
    public void twoSortArrayMerge() {
        Integer[] array1 = {1,2,3,4};
        Integer[] array2 = new Integer[]{2,3,3};
        //暴力合并
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(array1));
        list.addAll(Arrays.asList(array2));
        list.sort((x,y)->x.compareTo(y));
        System.out.println(Arrays.toString(list.toArray()));
        //归并合并
        int sumLength = array1.length + array2.length;
        int i = 0,j = 0,k = 0;
        int[] array = new int[sumLength];
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                array[k++] = array1[i++];
            } else {
                array[k++] = array2[j++];
            }
        }
        if (i != array1.length) {
            for (int l = i; l < array1.length; l++) {
                array[k++] = array1[l];
            }
        } else {
            for (int l = j; l < array2.length; l++) {
                array[k++] = array2[l];
            }
        }
        System.out.println(Arrays.toString(array));
    }

}
