package chap1;

import org.junit.jupiter.api.Test;


public class 出现k次与出现1次 {
    @Test
    //k个k进制数做不进位加法结果为0
    public void test1() {
        //1.构建数组
        int k = 3;
        int[] arr = {2, 2, 2, 1, 7, 7, 7, 3, 3, 3, 6, 6, 6, 0, 0, 0};
        int arr_len = arr.length;
        int max_len = 0;
        char[][] kRadix = new char[arr_len][];

        for (int i = 0; i < arr_len; i++) {
            //2.转换为K进制
            kRadix[i] = new StringBuilder(Integer.toString(arr[i], k)).reverse().toString().toCharArray();
            //3.计算二位数组最多有多少列
            if (kRadix[i].length > max_len) {
                max_len = kRadix[i].length;
            }
        }
        //4.存放不进位加法结果的数组
        int[] resArr = new int[max_len];
        //5.相加
        for (int i = 0; i < arr_len; i++) {
            for (int j = 0; j < max_len; j++) {
                if (j >= kRadix[i].length) {
                    resArr[j] += 0;
                } else {
                    resArr[j] += (kRadix[i][j] - '0');
                }
            }
        }
        int res=0;
        for (int i = 0; i < max_len; i++) {
            res+= (resArr[i]%k)*Math.pow(k,i);
        }

        System.out.println(res);
    }
}
