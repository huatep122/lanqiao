package chap04;

import java.util.Arrays;

public class 求子矩阵最大累加和 {
    /**
     * 思路：
     * 矩阵的每一行都可以看做是数组，求子矩阵的最大累加和，可以看做求数组的最大累加和
     * 如果只是考虑了一行或一个元素或两个元素作为子矩阵，这就是求子数组的最大累加和。
     * 当考虑多行时，就矩阵累加和，可以将每一列求和后转换为对数组求最大累加和。
     *
     */
    public static void main(String[] args) {
        int[][] A = {
                {-1,-1,-1},
                {0,2,2},
                {-1,-1,-1}
        };
        int m=A.length;
        int n=A[0].length;
        int[] sums=new int[n];
        int beginRow=0;
        int max=A[0][0];
        while (beginRow<m){
            for (int i = beginRow; i < m; i++) {
                for (int j = 0; j < n; j++) {//j只用来控制列上元素的累加
                    sums[j] += A[i][j];//保留之前行的结果
                }
                int maxSum = find(sums);//sums累加了一行后，对一行求最大和，之后再累加一行，再求两行的最大和。
                if (maxSum>max) max=maxSum;
            }
            Arrays.fill(sums,0);//求完一趟，之后将sums归零，开始以下一行为beginRow
            beginRow++;
        }
        System.out.println(max);
    }

    private static int find(int[] sums) {
        int sumJ = sums[0];
        int max = sumJ;
        for (int j = 1; j < sums.length; j++) {
            if (sumJ < 0)
                sumJ = sums[j];
            else
                sumJ += sums[j];
            if (max < sumJ)
                max = sumJ;
        }
        return max;
    }

}
