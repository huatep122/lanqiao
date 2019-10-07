package chap07;

import org.junit.jupiter.api.Test;

/**
 * 输入正整数n，l输出由前l个英文字母组成的，字典序第n小的困难的串.
 *
 * 要求字典序，那么在扩展串的时候能扩‘A’就扩‘A’，在向prefix后添加字符时，都从‘A’开始。
 */

public class 困难的串 {
    int count = 0;

    @Test
    public void test1() {
        dfs(3,4,"");
    }

    private void dfs(int l, int n, String prefix) {
        for (char i = 'A'; i < 'A' + l; i++) {
            if (check(prefix, i)) {//检查当前字符是否能扩展困难的串
                String s = prefix + i;
                System.out.println(s);
                count++;
                if (count == n) System.exit(0);
                dfs(l, n, s);//扩展后的困难串继续扩展
            }

        }
    }

    private boolean check(String prefix, char i) {
        int c = 0;//当前所指字符后跟c个字符作为一个字符串进行比较

        /*prefix已经为困难串，所以只需要看i字符加进来是否会打破困难串
         首先想到的是将i和最后一个字符进行比较，看二者是否相同。
         例如：
            ABA C
            先判断A和C：此时A后接0个字符进行判断；
            接下来判断AB和AC：所以要将指向最后A的指针j前移2个位置，指向第1个A，此时后面须接1个字符进行判断
                第一个字符串为AB，第二个字符串为AC
            之后后接的字符个数增加，j继续前移。

        */
        for (int j = prefix.length() - 1; j >= 0; j -= 2) {
            String s1 = prefix.substring(j, j + c + 1);
            String s2 = prefix.substring(j + c + 1) + i;
            if (s1.equals(s2)) return false;
            c++;//c后多跟一个字符
        }
        return true;
    }

}
