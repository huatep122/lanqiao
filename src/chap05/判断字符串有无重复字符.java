package chap05;

public class 判断字符串有无重复字符 {
    public static void main(String[] args) {
        //ascii code
        String str = "abcadef";
        System.out.println(check(str));
    }

    private static boolean check(String str) {
        int[] flag = new int[128];
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (flag[c]>0) return false;
            else flag[c]++;
        }
        return true;
    }

}
