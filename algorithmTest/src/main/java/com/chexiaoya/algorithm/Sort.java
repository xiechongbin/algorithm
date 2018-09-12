package com.chexiaoya.algorithm;

import android.util.Log;

/**
 * 算法类
 * Created by xcb on 2018/6/6.
 */
public class Sort {

    /**
     * 冒泡排序算法
     * 分类 -------------- 内部比较排序
     * 数据结构 ---------- 数组
     * 最差时间复杂度 ---- O(n^2)
     * 最优时间复杂度 ---- 如果能在内部循环第一次运行时,使用一个旗标来表示有无需要交换的可能,可以把最优时间复杂度降低到O(n)
     * 平均时间复杂度 ---- O(n^2)
     * 所需辅助空间 ------ O(1)
     * 稳定性 ------------ 稳定(指的是相等的元素是否会被改变相对位置)
     */
    public static int[] bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int size = array.length;
        int i;
        int j;
        for (i = 0; i < size - 1; i++) {//一共要排序length-1次
            Log.d("sort", "外层循环 第" + i + "次");
            for (j = 0; j < size - i - 1; j++) {//选出该趟排序的最大值往后移动
                Log.d("sort", ">>>>>>>nei层循环 第" + j + "次" + array[j] + "vs" + array[j + 1]);
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 冒泡排序算法 外层循环优化
     */
    public static int[] bubbleSort1(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int size = array.length;
        int i;
        int j;
        for (i = 0; i < size - 1; i++) {
            int flag = 0;//每次遍历标志位都要先置为0，才能判断后面的元素是否发生了交换
            for (j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = 1;
                }
            }
            //判断标志位是否为0，如果为0，说明后面的元素已经有序，就直接return
            if (flag == 0) {
                continue;
            }
        }
        return array;
    }

    /**
     * 冒泡排序算法 内层循环优化
     */
    public static int[] bubbleSort2(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int size = array.length;
        int i;
        int j;
        int pos = 0;
        int k = size - 1;
        for (i = 0; i < size - 1; i++) {
            int flag = 0;//每次遍历都要置换为0
            for (j = 0; j < k; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = 1;//只要有发生了交换，flag就置为1
                    pos = j;//循环里最后一次交换的位置 j赋给pos
                }
            }
            k = pos;
            if (flag == 1) {
                continue;
            }
        }
        return array;
    }

    /**
     * 鸡尾酒排序算法 又称定向冒泡排序算法  最大的值往下 最小的值往上，
     * 以序列(2,3,4,5,1)为例 鸡尾酒排序只需要访问一次序列就可以完成排序，
     * 但如果使用冒泡排序则需要四次。但是在乱数序列的状态下，鸡尾酒排序与冒泡排序的效率都很差劲
     */
    public static int[] cocktailSort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int size = array.length;
        int left = 0;
        int right = size - 1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            right--;
            for (int j = right; j > left; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
            left++;
        }
        return array;
    }


    /**
     * 选择排序算法
     * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。
     * 唯一的好处可能就是不占用额外的内存空间了吧。理论上讲，选择排序可能也是平时排序一般人想到的最多的排序方法了吧
     */
    public static int[] selectionSort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
