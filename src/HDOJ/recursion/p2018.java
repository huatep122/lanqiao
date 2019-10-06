package HDOJ.recursion;

import java.util.Scanner;

/**
 * 有一头母牛，它每年年初生一头小母牛。每头小母牛从第四个年头开始，每年年初也生一头小母牛。请编程实现在第n年的时候，共有多少头母牛？
 * 类似于斐波那契，可以用递归，也可以用DP
 */
public class p2018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr=new int[56];
        arr[1]=1;
        arr[2]=2;
        arr[3]=3;
        for (int i = 4; i <arr.length ; i++) {
            arr[i]=arr[i-1]+arr[i-3];
        }
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            if (n==0) break;
            System.out.println(arr[n]);
        }
    }
}
