package com.algorithm.sortAlgorithm;

import java.util.Arrays;

/**
 * @description:
 * @author: liuqiang
 * @time: 2021/2/20 9:29
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {2,3,8,9,23,1,7};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @description: 替换法实现希尔排序
     * @param
     * @return:
     * @author: liuqiang
     * @time: 2021/2/20 9:30
     */
    public static void shellSort(int[] arr){
        int temp = 0;
        for (int gap = arr.length/2; gap > 0; gap /= 2){//定义步长
            for (int i = gap; i < arr.length; i++) {//从第一个数的下一个步长位置数开始
                for (int j = i - gap; j >=0; j -= gap) {//循环比较
                    if (arr[j] > arr[j+gap]) {//判断交换
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * @description:  移位法的希尔排序
     * @param  待排序数组
     * @return: null
     * @author: liuqiang
     * @time: 2021/2/20 10:15
     */
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length/2; gap > 0; gap /= 2){//定义步长
            for (int i = gap; i < arr.length; i++) {//从第一个数的下一个步长位置数开始
                int minpoint = i;//保存下标位置
                int tempArr = arr[minpoint];//保存当前数据
                while (minpoint >= gap && tempArr < arr[minpoint-gap]) {//循环移动并交换
                    arr[minpoint] = arr[minpoint-gap];
                    minpoint -= gap;
                }
                arr[minpoint] = tempArr;
            }
        }
    }
}
