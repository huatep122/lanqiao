package HDOJ.recursion;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 错位排序
 * 现在的问题就是N张票的错排方式有几种。
 * 首先我们考虑，如果前面N-1个人拿的都不是自己的票，即前N-1个人满足错排，现在又来了一个人，他手里拿的是自己的票。
 * 只要他把自己的票与其他N-1个人中的任意一个交换，就可以满足N个人的错排。这时有N-1种方法。
 *
 * 另外，我们考虑，如果前N-1个人不满足错排，而第N个人把自己的票与其中一个人交换后恰好满足错排。
 * 这种情况发生在原先N-1人中，N-2个人满足错排，有且仅有一个人拿的是自己的票，而第N个人恰好与他做了交换，这时候就满足了错排。
 * 因为前N-1个人中，每个人都有机会拿着自己的票。所以有N-1种交换的可能
 */
public class p2048 {
    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat("00.00");
        long[][] dp = new long[21][2];
        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[2][0] = 2;
        dp[2][1] = 1;
        dp[3][0] = 6;
        dp[3][1] = 2;
        for (int i = 4; i < 21; i++) {
            dp[i][0] = i * dp[i - 1][0];
            dp[i][1] = (i - 1) * (dp[i - 1][1] + dp[i - 2][1]);
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int i=sc.nextInt();
            System.out.println(format.format(dp[i][1]*100.0/dp[i][0])+"%");
        }
    }
}
