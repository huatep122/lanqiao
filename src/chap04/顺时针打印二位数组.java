package chap04;

import org.junit.jupiter.api.Test;

public class 顺时针打印二位数组 {
    @Test
    public void test1() {
        int[][] matrix = {
                {1, 2, 3, 4, 1},
                {5, 6, 7, 8, 2},
                {9, 10, 11, 12, 3},
                {13, 14, 15, 16, 4},
                {9, 8, 7, 6, 5},
        };

        int row_move = 0;
        int col_move = 0;
        int row_fixed = matrix.length;
        int col_fixed = matrix[0].length;

        while (col_fixed > col_move && row_fixed > row_move) {
            int r = row_move;
            int c = col_move;
            while (c < col_fixed) {
                System.out.print(matrix[r][c] + " ");
                c++;
            }
            r++;
            c--;
            while (r < row_fixed) {
                System.out.print(matrix[r][c] + " ");
                r++;
            }
            r--;
            c--;
            while (c >= col_move) {
                System.out.print(matrix[r][c] + " ");
                c--;
            }
            c++;
            r--;
            while (r > row_move) {
                System.out.print(matrix[r][c] + " ");
                r--;
            }
            col_move++;
            row_move++;
            col_fixed--;
            row_fixed--;
        }

    }
}
