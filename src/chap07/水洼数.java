package chap07;

import org.junit.jupiter.api.Test;

public class 水洼数 {
    int count = 0;

    @Test
    public void test1() {
        char[][] table = new char[5][5];
        table[0] = "www..".toCharArray();
        table[1] = "w...w".toCharArray();
        table[2] = "..www".toCharArray();
        table[3] = "ww..w".toCharArray();
        table[4] = "www.w".toCharArray();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j]=='w'){
                    dfs(table,i,j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private void dfs(char[][] table, int x, int y) {
        if (x<0 || y<0) return;
        if (y==table[0].length || x==table.length) return;
        if (table[x][y]=='.') return;
        table[x][y]='.';
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i==0&&j==0) continue;
                dfs(table,x+i,y+j);
            }
        }
    }
}
