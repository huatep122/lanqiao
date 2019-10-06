package chap04;

import org.junit.jupiter.api.Test;

public class 子数组最大累加和 {
    int[] arr = {1, -2, 3, 5, -2, 6, -1};

    //当处理一个数时，将其加在前面的sum中得到负数时，则说明此项对最大和没有贡献
    //不应该将其考虑在内。同时每一项的处理都要与max比较，是否需要更新
    @Test
    public void test1() {
        int sumJ = arr[0];
        int max = sumJ;
        for (int j = 1; j < arr.length; j++) {
            if (sumJ < 0)
                sumJ = arr[j];
            else
                sumJ += arr[j];
            if (max < sumJ)
                max = sumJ;
        }
        System.out.println(max);
    }

    @Test
    public void test2(){
        int max=arr[0];
        int maxJ;
        for (int i = 0; i <arr.length ; i++) {
            maxJ=arr[i];
            int sum=maxJ;
            for (int j = i+1; j < arr.length; j++) {
                sum+=arr[j];
                if (sum>maxJ)
                    maxJ=sum;
            }
            if (maxJ>max)
                max=maxJ;
        }
        System.out.println(max);
    }
}
