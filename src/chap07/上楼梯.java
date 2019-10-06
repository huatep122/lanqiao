package chap07;

import org.junit.jupiter.api.Test;

/**
 * 递归和迭代都是数学归纳法，从少到多，从简到繁
 */
public class 上楼梯 {
    @Test
    //递归形式
    public void test1(){
        System.out.println(f(5));
    }
    private int f(int n) {
        if (n<=0) return 1;
        if (n==1) return 1;
        if (n==2) return 2;
        return f(n-1)+f(n-2)+f(n-3);
    }

    @Test
    //迭代形式
    public void test2(){
        System.out.println(f2(5));
    }

    private int f2(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        if (n==3) return 4;
        int x1 = 1;
        int x2 = 2;
        int x3 = 4;
        for (int i = 4; i <= n; i++) {
            int x_1 = x1;
            x1=x2;
            x2=x3;
            x3=x_1+x1+x2;
        }
        return x3;
    }

}
