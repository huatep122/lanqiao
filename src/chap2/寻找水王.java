package chap2;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;
import org.junit.jupiter.api.Test;

import javax.crypto.interfaces.PBEKey;

public class 寻找水王 {

    @Test
    public void test1(){
        int[] arr={2,2,2,2,1,3,4,5};
        System.out.println(f3(arr));
    }

    //消除法
    public int f1(int[] arr){
        int candidate=arr[0];
        int times=1;
        for (int i = 1; i <arr.length ; i++) {
            if (times==0){
                candidate=arr[i];
                times=1;
            }
            if (arr[i]==candidate)
                times++;
            else
                times--;
        }
        return candidate;
    }
    //顺序统计法
    public int f2(int[] arr,int low,int high,int k){
        int partition = partition(arr, low, high);
        int qK=partition-low+1;
        if (qK==k) return arr[partition];
        else if (qK>k) return f2(arr,low,partition-1,k);
        else return f2(arr,partition+1,high,k-qK);
    }

    //增强水王,只占一半，序列总数为偶数个
    //消除法，若最后times不等于0则说明最后一位就是水王，
    //  若最后times==0 ，说明水王交错在序列中，此时用for循环判断序列中最后一位是否为水王，若不是，则candidate保留的就是水王
    public int f3(int[] arr){
        int candidate=arr[0];
        int countOfLast=0;
        int times=1;
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i]==arr[arr.length-1]) countOfLast++;
            if (times==0){
                candidate=arr[i];
                times=1;
            }
            if (arr[i]==candidate)
                times++;
            else
                times--;
        }
        if (countOfLast==arr.length/2)
            return arr[arr.length-1];
        else return candidate;
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
