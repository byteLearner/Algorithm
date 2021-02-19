package com.algorithm.sortAlgorithm;

/**
 * @description:
 * @author: liuqiang
 * @time: 2021/2/5 10:55
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,5,4,8,12,34};
        quickSort(arr);
        for (Integer item : arr) {
            System.out.println(item+",");
        }
    }
    /**
     * @description: 快速排序
     * @param 待排序数组
     * @return: null
     * @author: liuqiang
     * @time: 2021/2/5 11:07
     */
    public static void quickSort(int [] arr) {
        sort(arr,0,arr.length-1);
    }

    /**
     * @description: 快速排序，以第一个数值为基准
     * @param arr 待排序数组，low数组下标最小值，high数组下标最大值
     * @return:
     * @author: liuqiang
     * @time: 2021/2/19 9:18
     */
    public static void sort(int[] arr,int low,int high) {
        if (low >= high) return;
        int i = low;
        int j = high;
        int index = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= index) j--;
            if (i < j) arr[i++] = arr[j];
            while (i < j && arr[i] <= index) i++;
            if (i < j) arr[j--] = arr[i];
        }
        arr[i] = index;
        sort(arr,low,i-1);
        sort(arr,i+1,high);
    }
}
