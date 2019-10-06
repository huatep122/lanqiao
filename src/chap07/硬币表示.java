package chap07;

import org.junit.jupiter.api.Test;

public class 硬币表示 {
    @Test
    public void test1() {
        int[] coin = {1, 5, 10, 25};
        System.out.println(f(30, coin, 3));
    }

    private int f(int n, int[] coin, int cur) {
        int res = 0;
        if (n == 0) return 1;
        if (cur == 0) return 1;
        for (int i = 0; i <= n / coin[cur]; i++) {
            res += f(n - i * coin[cur], coin, cur - 1);
        }
        return res;
    }

    @Test
    public void test2() {
        f2(30);
    }

    private void f2(int n) {
        int[] coins = {1, 5, 10, 25};
        int[][] dp = new int[4][n + 1];
        for (int i = 0; i < 4; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 0; k * coins[i] <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i]];
                }
            }
        }

        System.out.println(dp[3][n]);
    }
}
