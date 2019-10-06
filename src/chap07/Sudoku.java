package chap07;

import org.junit.jupiter.api.Test;

public class Sudoku {
    @Test
    public void test(){
        int[][] a = {
                {0,0,5,3,0,0,0,0,0},
                {8,0,0,0,0,0,0,2,0},
                {0,7,0,0,1,0,5,0,0},
                {4,0,0,0,0,5,3,0,0},
                {0,1,0,0,7,0,0,0,6},
                {0,0,3,2,0,0,0,8,0},
                {0,6,0,5,0,0,0,0,9},
                {0,0,4,0,0,0,0,3,0},
                {0,0,0,0,0,9,7,0,0}
        };
        dfs(a,0,0);
    }

    private void dfs(int[][] a, int row, int col) {
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(a[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        if (a[row][col] == 0) {//1.判断当前状态是否可以填写数字
            for (int i = 1; i <= 9; i++) {//2.当可以填写时，一个格子可以填写1-9，挨个试探
                if (check(a, row, col, i)) {//此处是否可以填写数字i，不能填写将尝试下一个数字
                    a[row][col] = i;
                    dfs(a, row + (col + 1) / 9, (col + 1) % 9);
                }
            }
            a[row][col] = 0;//3.共享的数组a，对该状态填写后且没有找到结果，应回溯至当前状态
        } else {
            dfs(a, row + (col + 1) / 9, (col + 1) % 9);
        }
    }

    private boolean check(int[][] a, int row, int col, int i) {
        //row、col
        for (int j = 0; j < a.length; j++) {
            if (a[row][j] == i) return false;
            if (a[j][col] == i) return false;
        }
        //table
        for (int j = row / 3 * 3; j < (row / 3 + 1) * 3; j++) {
            for (int k = col / 3 * 3; k < (col / 3 + 1) * 3; k++) {
                if (a[j][k]==i) return false;
            }
        }
        return true;
    }
}
