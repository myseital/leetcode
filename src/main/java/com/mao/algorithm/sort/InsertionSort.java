package com.mao.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author myseital
 * @date 2021/4/4 03:03
 */
public class InsertionSort {
    public static void main(String[] args) {
        /**
         * 第1次排序：[1, 18, 6, 27, 15, 7, 2]
         * 第2次排序：[1, 6, 18, 27, 15, 7, 2]
         * 第3次排序：[1, 6, 18, 27, 15, 7, 2]
         * 第4次排序：[1, 6, 15, 18, 27, 7, 2]
         * 第5次排序：[1, 6, 7, 15, 18, 27, 2]
         * 第6次排序：[1, 2, 6, 7, 15, 18, 27]
         */
        int[] insertNums = {18, 1, 6, 27, 15, 7, 2};
        System.out.println("排序前：" + Arrays.toString(insertNums));
        insertSort(insertNums);
        System.out.println("排序后：" + Arrays.toString(insertNums));
    }

    public static void insertionSort(int[] arr){
        for (int i=1; i<arr.length; ++i){
            int value = arr[i];
            int position=i;
            while (position>0 && arr[position-1]>value){
                arr[position] = arr[position-1];
                position--;
            }
            arr[position] = value;
        }//loop i
    }

    private static void insertSort(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int index = i;
            int temp = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > temp) {
                    // 交换位置
                    index = j;
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
            nums[index] = temp;
            System.out.println("排序" + i + "次：" + Arrays.toString(nums));
        }
    }

    private static void insertSort1(int[] nums) {
        int i, j, k;
        for (i = 1; i < nums.length; i++) {
            k = nums[i];
            j = i - 1;
            // 对 i 之前的数据，给当前元素找到合适的位置
            while (j >= 0 && k < nums[j]) {
                nums[j + 1] = nums[j];
                // j-- 继续往前寻找
                j--;
            }
            nums[j + 1] = k;
            System.out.print("第" + i + "次排序：");
            System.out.println(Arrays.toString(nums));
        }
    }
}
