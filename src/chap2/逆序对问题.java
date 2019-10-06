package chap2;

import org.junit.jupiter.api.Test;

public class 逆序对问题 {
    //归并排序过程中，每次从右侧选择元素，说明在剩余的元素中，右侧比左侧小
    //左侧有几个元素就有多少逆序对
    static int COUNT=0;
    public void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + ((high - low) >> 1);
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] helper=new int[high-low+1];
        int left = low;
        int right = mid + 1;
        int i=0;
        while (left <= mid && right <= high) {
            if (arr[left]<=arr[right])
                helper[i++] = arr[left++];
            else {
                helper[i++] = arr[right++];
                COUNT+=mid-left+1;
            }
        }
        while (left<=mid)helper[i++] = arr[left++];
        while (right<=high)helper[i++] = arr[right++];
        for (int j = 0; j <helper.length; j++) {
            arr[j+low]=helper[j];
        }
    }
    @Test
    public void test1(){
        int[] arr={1,2,5,4,3};
        mergeSort(arr,0,arr.length-1);
        System.out.println(COUNT);
    }
}

