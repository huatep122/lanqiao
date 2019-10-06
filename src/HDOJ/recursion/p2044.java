package HDOJ.recursion;

import java.util.Scanner;

/**
 * 有一只经过训练的蜜蜂只能爬向右侧相邻的蜂房，不能反向爬行。请编程计算蜜蜂从蜂房a爬到蜂房b的可能路线数。
 * 其中，蜂房的结构如下所示。
 */
public class p2044 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] arr=new long[51];
        arr[1]=0;
        arr[2]=1;
        arr[3]=2;
        for (int i = 4; i <=50 ; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        int n = sc.nextInt();
        while (n-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(arr[b-a+1]);
        }

    }
}
