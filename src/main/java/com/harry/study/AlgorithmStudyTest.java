package com.harry.study;

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

    /**
     * 求最大不重复的字串
     */
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

    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
     *
     *
     */
    @Test
    public void findRepeatNumber() {
        int[] nums = new int[]{0,2,5,2,3,4,4};
        int temp;
        for (int i = 0;i < nums.length;i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    System.out.println(nums[i]);
                    break;
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
    }

    /**
     * 排序组合合并
     *
     */
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

    /**
     * 数组中有个数字超过半数重复，请找出来
     */
    @Test
    public void testFindRepeatNum() {
        int[] nums = new int[]{4,4,6,1,4};
        int result = nums[0];
        int count = 1;
        for (int i = 1;i<nums.length;i++) {
            if (nums[i] == result) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result = nums[i];
                count = 1;
            }
        }
        System.out.println(result);
    }

    /**
     * 数组中数字成对出现，只有两个是不成对的，找出来
     */
    @Test
    public void test1SizeNum() {
        int sum = 0;
        int[] nums = new int[]{4,4,6,1};
        for (int i = 0;i<nums.length;i++) {
            sum ^= nums[i];
        }
        System.out.println(sum);

        int first = 1;
        while ((sum&first) == 0) {
            first = first << 1;
        }
        System.out.println(first);
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            //将数组分类。
            if((nums[i]&first)==0){
                result[0]^=nums[i];
            } else{
                result[1]^=nums[i];
            }
        }
        System.out.println(result[0] +"----" + result[1]);
    }

}
