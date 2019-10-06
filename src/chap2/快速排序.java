package chap2;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class 快速排序 {
    @Test

    public void test1() {
        int[] arr = {11, 1, -10, 7, 3, 3, 3, 3, 3, 3, 12, 9};
        quickSort1(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partition = partition2(arr, begin, end);
            quickSort(arr, begin, partition - 1);
            quickSort(arr, partition + 1, end);
        }
    }
    //三分法快排
    public void quickSort1(int[] arr, int begin, int end) {
        if (begin < end) {
            int[] partitions = partition3(arr, begin, end);
            quickSort(arr, begin, partitions[0] - 1);
            quickSort(arr, partitions[1], end);
        }
    }

    //单向扫描分区法,sp指针遇到小于等于主元则向右移动，bigger右侧的元素均大于主元
    public int partition(int[] arr,int begin,int end){
        int sp=begin+1;
        int bigger=end;
        int pivot=arr[begin];

        while (sp<=bigger){
            while (sp<=bigger && arr[sp]<=pivot) sp++;
            while (sp<=bigger && arr[bigger]>pivot) bigger--;
            if (sp<bigger){
                swap(arr,sp,bigger);
                bigger--;
            }
        }
        swap(arr,begin,bigger);
        return bigger;
    }
    public int partition1(int[] arr, int begin, int end) {
        int sp = begin + 1;
        int bigger = end;
        int pivot = arr[begin];

        while (sp <= bigger) {
            if (arr[sp] <= pivot)
                sp++;
            else {
                swap(arr, sp, bigger);
                bigger--;
            }
        }
        //sp最终指向第一个大于主元的位置，bigger最终指向最后一个小于等于主元的位置
        //需要将bigger和起始位置互换
        swap(arr, begin, bigger);
        return bigger;
    }

    //双向扫描分区法，
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

    //三指针分区法
    public int[] partition3(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        int equal = begin;//first equals to pivot
        int sp = begin + 1;//scanner
        int bigger = end;//right hand side bigger than pivot
        int[] res = new int[2];
        while (sp <= bigger) {
            if (arr[sp] < pivot) {
                swap(arr, sp, equal);
                equal++;
            } else if (arr[sp] > pivot) {
                swap(arr, sp, bigger);
                bigger--;
            } else
                sp++;
        }
        res[0] = equal;
        res[1] = sp;//sp最终定位到第一个大于主元的位置
        return res;
    }


    private void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
