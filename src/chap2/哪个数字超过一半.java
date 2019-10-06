package chap2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 哪个数字超过一半 {
    @Test
    public void test1(){
        int[] arr={1,2,2,2,2,9,3,3,2};
        System.out.println(f2(arr));
    }
    //排序，中间即为所求 O(nlogn)
    public int f1(int[] arr){
        Arrays.sort(arr);
        return arr[(arr.length-1)>>1];
    }
    //消除法  O(n)
    public int f2(int[] arr){
        int candidate=arr[0];
        int times=1;

        for (int i = 1; i < arr.length; i++) {
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
    //顺序统计的第N/2个就是结果 O(n)
}
