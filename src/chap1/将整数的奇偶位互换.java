package chap1;

import org.junit.jupiter.api.Test;

public class 将整数的奇偶位互换 {
    //数据与01010101...0101相与将保留奇数位，偶数位全为0。与101010...1010相与将保留数据的偶数位。
    //将奇偶结果错位后异或起来
    @Test
    public void test1(){
        int ji=0x55555555;
        int ou=0xaaaaaaaa;
        int res = ((9&ji)<<1)^((9&ou)>>1);
        System.out.println(res);
    }
}
