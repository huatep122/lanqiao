package chap04;

public class Z型打印二维数组 {
    public static void main(String[] args) {
        boolean direction_flag = true;
        int[][]  matrix={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int row = 0;
        int col = 0;
        int count=0;
//        while (!(row==matrix.length-1 && col==matrix[0].length-1)) {
//            if (!direction_flag) {
//                while (row>=0 && col<=matrix[0].length){
//                    System.out.print(matrix[row--][col++]+" ");
//                }
//                if (row<0) row=0;
//                direction_flag=true;
//                col++;
//            }else {
//                while (col>=0 && row<=matrix.length){
//                    System.out.print(matrix[row++][col--]+" ");
//                }
//                if (col<0) col=0;
//                direction_flag=false;
//                row++;
//            }
//        }
        while (count!=matrix.length*matrix[0].length){
            if (direction_flag){//向右上
                while (row>=0 && col<matrix[0].length){
                    System.out.print(matrix[row][col]+" ");
                    count++;
                    if (row==0 ||  col==matrix[0].length-1)
                        break;//
                    else {
                        row--;
                        col++;
                    }
                }
                direction_flag=false;
                if (col<matrix[0].length-1)
                    col++;
                else
                    row++;
            }else {//向左下
                while (col>=0 && row<matrix.length){
                    System.out.print(matrix[row][col]+" ");
                    count++;
                    if (col==0 || row==matrix.length-1)
                        break;
                    else {
                        row++;
                        col--;
                    }
                }
                direction_flag=true;
                if (row<matrix.length-1)
                    row++;
                else
                    col++;
            }
        }
    }
}
