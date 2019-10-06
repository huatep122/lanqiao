package HDOJ.recursion;

import java.util.Scanner;

/**
 * 在2×n的一个长方形方格中,用一个1× 2的骨牌铺满方格,输入n ,输出铺放方案的总数.
 * 例如n=3时,为2× 3方格，骨牌的铺放方案有三种,如下图：
 */
public class p2046 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] dp=new long[51];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i < dp.length; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        while (sc.hasNext()){
            System.out.println(dp[sc.nextInt()]);
        }

    }
}
