package chap07;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class 全排列 {
    @Test
    //逐步生成
    public void test1() {
        ArrayList<String> res = getPermutation1("abc");
        System.out.println(res);
    }
    private ArrayList<String> getPermutation1(String str) {
        int len = str.length();
        ArrayList<String> res = new ArrayList<>();
        res.add(str.charAt(0) + "");

        for (int i = 1; i < len; i++) {//将str中每个char都添加进去
            ArrayList<String> newRes = new ArrayList<>();
            char cur = str.charAt(i);
            for (String s :
                    res) {
                String newStr = cur + s;//将本轮字符加在上一轮字符串的前面
                newRes.add(newStr);
                newStr = s + cur;//加在后面
                newRes.add(newStr);
                for (int j = 1; j < s.length(); j++) {//在中间进行插入
                    newStr = s.substring(0, j) + cur + s.substring(j);
                    newRes.add(newStr);
                }
            }
            res = newRes;//更新res
        }
        return res;
    }

    @Test
    public void test2() {
        ArrayList<String> res = new ArrayList<>();
        getPermutation2(res,"abc",0);
        System.out.println(res);
    }
    //交换法，将每个元素都交换到第一个位置，将剩余的进行递归排列
    private void getPermutation2(ArrayList<String> res,String str, int cur) {
        if (cur == str.length()-1){
            res.add(str);
            return;
        }
        for (int i = cur; i < str.length(); i++) {
            str = swap(str,cur, i);//与首位交换
            getPermutation2(res,str,cur+1);//
            str = swap(str,cur, i);//回溯至前一状态
        }
    }
    //交换字符串两个字符
    private String swap(String str, int cur,int i) {
        char[] chars = str.toCharArray();
        char temp = chars[cur];
        chars[cur] = chars[i];
        chars[i] = temp;
        return new String(chars);
    }

    @Test
    public void test3(){

    }
}
