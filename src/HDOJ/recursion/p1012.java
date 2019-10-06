package HDOJ.recursion;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;


public class p1012 {

    public static void main(String[] args) {
        DecimalFormat df=new DecimalFormat("0.000000000");
        int[] arr=new int[10];
        double[] res=new double[10];
        arr[0]=1;
        //calculate factorial
        for (int i = 1; i < 10; i++) {
            arr[i]=i*arr[i-1];
        }
        //
        res[0]=1.0/arr[0];
        System.out.println("n e");
        System.out.println("- -----------");
        System.out.println(0+" "+(int) res[0]);
        for (int i = 1; i < 10; i++) {
            res[i]=res[i-1]+(1.0/arr[i]);
        }
        System.out.println(1+" "+(int) res[1]);
        System.out.println(2+" "+res[2]);
        for (int i = 3; i < 10; i++) {
            System.out.println(i+" "+df.format(res[i]));
        }
    }
}
