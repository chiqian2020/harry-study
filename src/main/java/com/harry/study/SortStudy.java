package com.harry.study;

import java.util.Arrays;

/**
 * BubbleSort
 * 冒泡排序
 * @author harry
 * @date 2021/1/5 8:56 下午
 **/
public class SortStudy {

    public static void main(String[] args) {
        int[] array = new int[]{0,53,63,38,71,25,22,11,95,38};
        int[] sort = selectSort(array);
        System.out.println(Arrays.toString(sort));
    }

    /**
     * 时间复杂度 O(n^2)
     * @param array
     * @return
     */
    private static int[] bubbleSort(int[] array) {
        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length -1; j++) {
                    if (array[j] > array[j+1]) {
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }

            }
        }
        return array;
    }

    /**
     * 时间复杂度O(n*n)
     * @param array
     * @return
     */
    private static int[] selectSort(int[] array) {
        if (array != null && array.length > 0) {
            int minIndex,temp;
            for (int i = 0; i < array.length-1; i++) {
                minIndex = i;
                for (int j = i+1; j < array.length; j++) {
                    if (array[j] < array[minIndex]) {
                        minIndex = j;
                    }
                }
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;

            }
        }
        return array;
    }

}
