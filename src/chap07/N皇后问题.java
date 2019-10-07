package chap07;

import org.junit.Test;

public class N皇后问题 {
    int[] rec=new int[4];
    int n=4;
    int count=0;
    @Test
    public void test1(){
        dfs(0);
        System.out.println(count);
    }

    private void dfs(int row) {
        if (row==n){
            count++;
            return;
        }
        for (int i = 0; i <n ; i++) {//在一行的每一列进行尝试
            boolean isOk = true;
            for (int j = 0; j < row; j++) {//只需要判断之前行会不会冲突即可
                if (rec[j] == i || j+rec[j]==row+i || rec[j]-j == i-row){
                    isOk=false;
                    break;
                }
            }
            if (isOk){//可以放
                rec[row]=i;
                dfs(row+1);
                rec[row]=0;
            }
        }
    }
}
