package chap05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 变形词：两个串有相同的字符及数量组成，abc,cba,bca为变形词
 * 给定一个stringA和一个stringB，返回一个bool，代表两个字符串是否可以重新排列后相同
 */
public class 变形词问题 {
    @Test
    //方式1，对两个字符串排序后比较时候相同
    public void test1() {
        String A = "abaacd";
        String B = "bacd";
        System.out.println(fun2(A, B));
    }

    private boolean fun2(String a, String b) {
        int[] flag = new int[256];
        //字符串a先进行统计
        for (int i = 0; i < a.length(); i++) {
            int c = a.charAt(i);
            flag[c]++;
        }
        //字符串b进行统计,消除重复
        for (int i = 0; i < b.length(); i++) {
            int c = b.charAt(i);
            flag[c]--;
            if (flag[c]<0) return false;
        }
        //最后在进行一次排查，看是否有b没能消除的，若存在则两个部位变形词
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]>0)return false;
        }
        return true;
    }

    private boolean fun1(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        if (len1 != len2)
            return false;
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1,chars2);

    }

}
