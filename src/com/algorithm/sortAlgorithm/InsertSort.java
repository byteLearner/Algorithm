package com.algorithm.sortAlgorithm;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3,5,2,7,45,6,1};
        insertSortMax(arr);
        for (Integer i : arr) {
            System.out.print(i+",");
        }
    }
    /**
     * @description: 插入排序
     * @param 待排序数组
     * @return: null
     * @author: liuqiang
     * @time: 2021/2/5 11:05
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length ==1) return;
        for (int i = 1; i < arr.length; i++) {
            int minPoint = i;
            int temp = arr[i];
            while (minPoint > 0 && temp < arr[minPoint-1]) {//每次移动一位，判断目标值是否小于当前值
                arr[minPoint] = arr[minPoint-1];//目标值小于当前值则移动
                minPoint--;
            }
            arr[minPoint] = temp;
        }
    }
    /**
     * @description: 优化插入排序
     * @return: null
     * @author: Liuqiang
     * @time: 2021/2/2 9:37
     */
    public static void insertSortMax(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length ==1) return;
        for (int i = 1; i < arr.length; i++) {
            int insertPoint = arr[i];//insertPoint为当前值
            if (arr[i-1] > arr[i]){
                int num = binarySearch(i-1,arr,arr[i]);//二分查找查找
                for (int j = i; j > num; j--) {
                    arr[j] = arr[j-1];
                }
                arr[num] = insertPoint;
            }
        }
    }
   /**
    * @description: 二分查找
    * @param null
    * @return: 插入位置下标前一位
    * @author: Liuqiang
    * @time: 2021/2/2 9:32
    */  
    public static int binarySearch(int end,int[] arr,int target) {
        int start = 0;
        int mid;
        while (end  > start + 1) {
            mid = start + (end - start)/2;
            if (arr[mid] > target) {
                end = mid;
            }else {
                start = mid;
            }
        }
        return start;
    }
}
