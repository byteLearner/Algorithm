package com.algorithm.sortAlgorithm;


public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,4,5,8,7,9,12,1};
        bubbleSort(arr);
        for (Integer i : arr) {
            System.out.print(i+",");
        }

    }

    /**
     * @description: 冒泡排序
     * @param  待排序数组
     * @return: null
     * @author: liuqiang
     * @time: 2021/2/5 11:04
     */
    public static void  bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) return;
        boolean flag = false;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    if (!flag) flag = true;
                }
            }
            if (!flag) return;
        }
    }
}
