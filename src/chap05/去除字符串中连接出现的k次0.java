package chap05;

public class 去除字符串中连接出现的k次0 {
    public static void main(String[] args) {
        String str="A00000B00";
        int count=0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c=='0')
                count++;
            else {
                if (count==0)
                    sb.append(c);
                else {
                    for (int j = 0; j < count%4; j++) {
                        sb.append('0');
                    }
                    count=0;
                    sb.append(c);
                }
            }
        }
        for (int j = 0; j < count%3; j++) sb.append('0');
        System.out.println(sb.toString());
    }
}
