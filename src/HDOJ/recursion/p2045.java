package HDOJ.recursion;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Scanner;

/**
 * 有排成一行的ｎ个方格，用红(Red)、粉(Pink)、绿(Green)三色涂每个格子，每格涂一色，
 * 要求任何相邻的方格不能同色，且首尾两格也不同色．求全部的满足要求的涂法.
 * 以上就是著名的RPG难题.
 */
public class p2045 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] res=new long[51];
        res[1]=3;
        res[2]=6;
        res[3]=6;
        for (int i = 4; i <res.length; i++) {
            res[i]=res[i-1]+res[i-2]*2;
        }
        while (sc.hasNext()){
            System.out.println(res[sc.nextInt()]);
        }
    }
}
