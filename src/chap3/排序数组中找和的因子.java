package chap3;

import org.junit.jupiter.api.Test;

public class 排序数组中找和的因子 {
    //三元不降序组
    @Test
    public void test1() {
        int arr[] = {-8, -4, -3, 0, 2, 4, 5, 8, 9, 10};
        int k=10;
        for (int i = 0; i < arr.length; i++) {
            int left=i+1;
            int right=arr.length-1;
            int k_=k-arr[i];
            while (left<right){
                if (arr[left]+arr[right]>k_)
                    right--;
                else if (arr[left]+arr[right]<k_)
                    left++;
                else{
                    System.out.println(arr[i]+" "+arr[left]+" "+arr[right]);
                    left++;
                    right--;
                }
            }
        }
    }


}
