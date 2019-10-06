package chap2;

import org.junit.jupiter.api.Test;

public class 最小可用id {
    @Test
    public void test1(){
        int[] arr={12,3,13,9,123,4,5,1,2};
        System.out.println(f1(arr,0,arr.length-1));
    }
    //利用partition
    //id从小到大顺序排列（1-100），最中间的值应该为50。若比50大说明左边稀疏，有最小id，否则在右侧有最小id
    //有点二分法的意思在里面，外面是二分，里面是partition的topK问题运用
    //通过partition划分为相对有序（轴值左右），只比较轴值。
    public int f1(int[] arr,int low,int high){
        int mid=low+((high-low)>>1);
//        int i = f2(arr, low, high, mid);
        int i = f2(arr, low, high, mid-low+1);
        if (low>high) return low+1;
        if (i==mid+1)
            return f1(arr,mid+1,high);
        else
            return f1(arr,low,mid-1);
    }
    public int f2(int[] arr,int low,int high,int k){
        int partition = partition(arr, low, high);
        int qK=partition-low+1;
        if (qK==k) return arr[partition];
        else if (qK>k) return f2(arr,low,partition-1,k);
        else return f2(arr,partition+1,high,k-qK);
    }
    private int partition(int[] arr, int begin, int end) {
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

    private void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
