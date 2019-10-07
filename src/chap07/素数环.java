package chap07;
import org.junit.jupiter.api.Test;


public class 素数环 {
    int n=4;
    int count=0;
    @Test
    public void test1(){
        int[] rec=new int[n+1];
        rec[1]=1;
        dfs(rec,2);
        System.out.println(count);
    }
    private void dfs(int[] rec, int k) {
        if (k==n && primeNumber(rec[1]+rec[k])){
            count++;
            return;
        }
        for (int i = 2; i <= n; i++) {
            if (check(rec,k,i)){
                rec[k]=i;
                dfs(rec,k+1);
                rec[k]=0;
            }
        }
    }

    private boolean check(int[] rec, int k, int i) {
        for (int j = 0; j < rec.length; j++) {
            if (rec[j]==i) return false;
        }
        if (!primeNumber(i+rec[k-1]))return false;
        return true;
    }

    private boolean primeNumber(int k) {
        for (int i = 2; i*i <=k ; i++) {
            if (k%i==0) return false;
        }
        return true;
    }

}
