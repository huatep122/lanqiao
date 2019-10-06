package chap2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 乱序数组中第k小的数 {
    @Test
    public void test1() {
        int[] arr = {1, 8, 3, 11, 9, 6, 7};
        System.out.println(f2(arr, 4, 0, arr.length - 1));
    }

    //1.先排序，后找下标为k-1的,时间复杂度为 nlgn
    public int f1(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }
    //2.冒泡法
    //3.快速排序的一趟可以确定一个轴值最终的位置
    //2.3属于同一思路，利用排序算法一趟确定一个元素的性质
    //4.堆排序，可用来处理海量数据
    //O(n)复杂度
    public int f2(int[] arr, int k, int low, int high) {
        int partition = partition2(arr, low, high);
        int q=partition-low+1;//主元在第几个位置上
        if (q == k) {
            return arr[partition];
        } else if (q > k) {
            return f2(arr, k, low, partition - 1);
        } else
            return f2(arr, k-q, partition + 1, high);
    }

    private void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    public int partition2(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        int sp = begin + 1;
        int bigger = end;

        while (sp <= bigger) {
            while (sp <= bigger && arr[sp] <= pivot) sp++;
            while (sp <= bigger && arr[bigger] > pivot) bigger--;
            if (sp < bigger) {
                swap(arr, sp, bigger);
            }
        }
        swap(arr, begin, bigger);
        return bigger;
    }
}
