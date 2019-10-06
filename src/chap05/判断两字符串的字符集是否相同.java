package chap05;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class 判断两字符串的字符集是否相同 {
    @Test
    //利用哈希
    public void test1(){
        Map<Character,Integer> map=new HashMap<>();
        String str1 = "abcde";
        String str2 = "abcdef";

        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (map.get(c)==null)
                map.put(c,1);
        }
        for (int i = 0; i < str2.length() ; i++) {
            if (map.get(str2.charAt(i))==null)
                System.out.println(false);
        }
    }
}
