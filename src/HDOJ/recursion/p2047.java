package HDOJ.recursion;

import java.util.Scanner;

/**
 * 阿牛从家里拿来了一块上等的牛肉干，准备在上面刻下一个长度为n的只由"E" "O" "F"三种字符组成的字符串
 * （可以只有其中一种或两种字符，但绝对不能有其他字符）,阿牛同时禁止在串中出现O相邻的情况，他认为，
 * "OO"看起来就像发怒的眼睛，效果不好。
 */
public class p2047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] dp = new long[41];
        dp[1] = 3;
        dp[2] = 8;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = 2 * (dp[i - 1] + dp[i - 2]);
        }
        while (sc.hasNext()){
            System.out.println(dp[sc.nextInt()]);
        }
    }
}
