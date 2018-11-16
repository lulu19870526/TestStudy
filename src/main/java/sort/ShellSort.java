package sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {

        int arr[] = {1, 4, 6, 8, 2, 5, 3, 7, 9};
        System.out.println("数组排序前顺序：");
        for (int n : arr) {
            System.out.print(n + " ");
        }

        //直接插入排序
        sort(arr);

        System.out.println("\n数组排序后顺序：");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

        private static void sort(int[] arr) {
        // i表示希尔排序中的第n/2+1个元素（或者n/4+1）
        // j表示希尔排序中从0到n/2的元素（n/4）
        // r表示希尔排序中n/2+1或者n/4+1的值
        int i, j, r, tmp;
        // 划组排序
        for(r = arr.length / 2; r >= 1; r = r / 2) {
            for(i = r; i < arr.length; i++) {
                tmp = arr[i];
                j = i - r;
                // 一轮排序
                while(j >= 0 && tmp < arr[j]) {
                    arr[j+r] = arr[j];
                    j -= r;
                }
                arr[j+r] = tmp;
            }
            System.out.println(i + ":" + Arrays.toString(arr));
        }
    }
}
