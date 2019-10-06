package chap05;

import org.junit.Test;

import java.util.ArrayList;

public class 部分和 {
    @Test
    //使用dfs
    public void test1() {
        int[] coin = {1, 2, 4, 7};
        ArrayList<Integer> ints = new ArrayList<>();
        dfs(coin, 13, 0, ints);
    }

    private void dfs(int[] coin, int k, int cur, ArrayList<Integer> ints) {
        if (k == 0) {
            System.out.println("Yes");
            System.out.println(ints);
            System.exit(0);
        }
        if (k < 0 || cur == coin.length)
            return;
        dfs(coin, k, cur + 1, ints);
        ints.add(coin[cur]);
        int index = ints.size() - 1;
        dfs(coin, k - coin[cur], cur + 1, ints);
        ints.remove(index);
    }

    @Test
    public void test2() {
        int[] coins = {1, 2, 4, 7};
        int k =13;
        int count=0;
        for (int i = (int) (Math.pow(2,coins.length)-1); i >0 ; i--) {
            int sum=0;
            for (int j = coins.length-1; j >=0 ; j--) {
                if (((i>>j)&1)==1){
                    sum+=coins[j];
                }
            }
            if (sum==k) count++;
        }
        System.out.println(count);
    }
}
