package chap1;

import org.junit.jupiter.api.Test;


public class 二进制中1的个数 {
    int N = 27;
    int count;
    @Test
    //方法一：将1左移，将原始数据与之相与。若结果与1左移相等，则说明原始数据的二进制形式中含一个1.
    public void test1(){
        count=0;
        for (int i = 0; i < 32; i++) {
            if ((N&(1<<i)) == (1<<i)){
                count++;
            }
        }
        System.out.println(Integer.toBinaryString(N));
        System.out.println(count);
    }
    //方法二：将原始数据无符号右移，&1，结果为1则含一个1
    @Test
    public void test2(){
        count=0;
        for (int i = 0; i < 32; i++) {
            if (((N>>>i)&1)==1) count++;
        }
        System.out.println(count);
    }
    //方法三：N&(N-1)相当于将二进制N中最低位的1消除。
    @Test
    public void test3(){
        count=0;
        while (N!=0){
            N=(N&(N-1));
            count++;
        }
        System.out.println(count);
    }

    //扩展问题：用一条语句判断整数是否为2的整数次方
    //判断二进制数是否只含一个1，用N&(N-1)一次消除一个1
    @Test
    public void test4(){
        int num=61;
        if ((num&(num-1))==0)
            System.out.println("Y");
        else
            System.out.println("N");
    }
}
