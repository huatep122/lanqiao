package chap2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 归并排序 {
    @Test
    public void test1() {
        int[] arr = {9, 1, 12, 2, 3, 9, 6};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + ((high - low) >> 1);
            mergeSort(arr, low, mid);//对左半部分排序
            mergeSort(arr, mid + 1, high);//对右半部分排序
            merge(arr, low, mid, high);//合并
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = 0;
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right])
                temp[i++] = arr[left++];
            else
                temp[i++] = arr[right++];
        }
        while (left <= mid) temp[i++] = arr[left++];
        while (right<=high) temp[i++] = arr[right++];
        for (int j = 0; j < temp.length; j++) {
            arr[low+j]=temp[j];
        }
    }

}
