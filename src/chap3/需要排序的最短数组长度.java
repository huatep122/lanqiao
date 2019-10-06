package chap3;

import org.junit.jupiter.api.Test;

import java.util.logging.Level;

public class 需要排序的最短数组长度 {
    @Test
    public void test1() {
        int[] arr = {1, 5, 3, 4, 2, 6, 7};
        System.out.println(getMinLength(arr));
    }

    //从前向后遍历数组，初始 max = arr[0]，若遇到大于max则更新max，若遇到小于max的值，用k记录。不断地更新max和k
    //k记录了确定地不需要排序的升序部分开始前的一个位置，它后面是已经有序的（右侧）
    //从后向前遍历数组，初始 min = arr[len-1]，若遇到小于min则更新min，若遇到大于min的值，用j记录。不断更新min和j
    //j记录了不需要排序的最后一个位置，它前面都已经是升序的了。（左侧）
    private int getMinLength(int[] arr) {
        int max = arr[0];
        int min = arr[arr.length - 1];
        int k = 0;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= max)
                max = arr[i];
            else
                k = i;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= min)
                min = arr[i];
            else
                j = i;
        }
        return k - j + 1;
    }
}
