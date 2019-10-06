package chap05;

import org.junit.jupiter.api.Test;

/**
 * 将两个旋转串拼接在一起，其中包含了旋转之前的原串
 */
public class 旋转词 {
    @Test
    public void test1(){
        System.out.println(check("abc", "cba"));

    }
    public static boolean check(String str1,String str2){
        StringBuilder stringBuilder = new StringBuilder(str2).append(str2);
        return stringBuilder.toString().contains(str1);
    }
}
