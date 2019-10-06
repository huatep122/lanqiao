package chap05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 替换字符串中的空格 {
    @Test
    public void test1(){
        String str="Mr John Smith";
        String s = str.replaceAll("\\s", "%20");
        System.out.println(s);
    }
    @Test
    public void test2(){
        /**
         * 先统计有多少个空格，每个空格意味着要扩充两位，指针p1指向最后的末尾，p2指字符串末尾，p2先向前走，若为字符，则p1位置更新
         * 否则p1连着向前3个位置都要被填充
         */
        String str = "Mr John Smith";
        int count=str.length();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==' ')
                count+=2;
        }
        char[] newArray = new char[count];
        Arrays.fill(newArray,' ');
        char[] chars = str.toCharArray();
        int i=chars.length-1;
        int j=newArray.length-1;
        while (i>=0){
            if (chars[i]!=' ')
                newArray[j--]=chars[i--];
            else{
                i--;
                newArray[j--]='0';
                newArray[j--]='2';
                newArray[j--]='%';
            }
        }
        System.out.println(new String(chars));
        System.out.println(new String(newArray));
    }
}
