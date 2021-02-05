package com.algorithm.sortAlgorithm;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {2,3,8,9,23,1,7};
        selectSortMax(arr);
        for (Integer i : arr) {
            System.out.print(i+",");
        }
    }
    /**
     * @description: 选择排序
     * @param 待排序数组
     * @return: null
     * @author: liuqiang
     * @time: 2021/2/5 11:06
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length == 0||arr.length ==1) return;
        int len = arr.length;
        int minPoint;
        for (int i = 0; i < len-1; i++) {
            minPoint = i;
            for (int j = i+1; j < len; j++) {
                if (arr[j] < arr[minPoint]) {//比较出最小元素
                    minPoint = j;
                }
            }
            if (minPoint != i) {//判断最小元素是否是是否是当前位置，不是则交换
                int tempnum = arr[i];
                arr[i] = arr[minPoint];
                arr[minPoint] = tempnum;
            }
        }
    }

    /**
     * @description: 优化选择排序
     * @param 待排序数组
     * @return: null
     * @author: liuqiang
     * @time: 2021/2/5 11:06
     */
    public static void selectSortMax(int[] arr) {
        if (arr == null || arr.length == 0||arr.length ==1) return;
        int len = arr.length;
        int minPoint;
        int maxPoint;
        for (int i = 0; i < len/2; i++) {
            minPoint = i;
            maxPoint = i;
            for (int j = i+1; j < len-i; j++) {
                if (arr[j] < arr[minPoint]) {//比较出最小元素
                    minPoint = j;
                }else if(arr[j] > arr[maxPoint]) {//比较出最大元素
                    maxPoint = j;                }
            }
            if (minPoint != i) {//判断最小元素是否是是否是当前位置，不是则交换
                int tempnum = arr[i];
                arr[i] = arr[minPoint];
                arr[minPoint] = tempnum;
                if(maxPoint == i) {//若最大元素下标为i(i值在之前已经交换过了)，所以指向minPoint
                    maxPoint = minPoint;
                }
            }
            if (maxPoint != len - i - 1) {//判断最大元素是否是是否是当前位置，不是则交换
                int tempMax = arr[len - i - 1];
                arr[len - i - 1] = arr[maxPoint];
                arr[maxPoint] = tempMax;
            }
        }
    }
}
