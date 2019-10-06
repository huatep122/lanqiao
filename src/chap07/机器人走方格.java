package chap07;

import org.junit.jupiter.api.Test;

public class 机器人走方格 {
    @Test//递归形式
    public void test1(){
        System.out.println(f(4, 3));
    }
    private int f(int x,int y) {
        if (x==1 || y==1) return 1;
        else return f(x,y-1) + f(x-1,y);
    }

    @Test//正向思维，迭代形式
    public void test2(){
        System.out.println(f2(4, 3));
    }

    private int f2(int x, int y) {
        int[][] dp =new int[x+1][y+1];
        for (int i = 1; i <=x ; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <=y ; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <=x ; i++) {
            for (int j = 2; j <=y; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[x][y];
    }
}
