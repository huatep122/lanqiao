package chap2;

import org.junit.jupiter.api.Test;

public class 递归例题 {
    @Test
    public void test1(){
        System.out.println(f4(2, 10));
    }
    //上楼梯
    public int f1(int n){
        if (n==0) return 1;
        if (n==1) return 1;
        if (n==2) return 2;
        return f1(n-1)+f1(n-2)+f1(n-3);
    }
    //旋转数组的最小数字
    public int f2(int[] arr){
        int begin=0;
        int end=arr.length-1;
        while (begin+1<end){
            int mid=begin+((end-begin)>>1);
            if (arr[mid]>arr[begin]){//左边为有序的，所以在右侧找
                begin=mid;
            }else {
                end=mid;
            }
        }
        return arr[end];
    }
    //在有空字符串中的有序字符串数组中查找
    public int f3(String[] arr,String key){
        int begin=0;
        int end=arr.length-1;
        int mid;
        while (begin<=end){
            //定中
            mid = begin+((end-begin)>>1);
            while (arr[mid].equals("")){
                mid++;
                if (mid>end) return -1;
            }
            //比较
            if (arr[mid].compareTo(key)<0){
                begin=mid+1;
            }else if (arr[mid].compareTo(key)>0){
                end=mid-1;
            }else return mid;
        }
        return -1;
    }
    //高效的求a的n次幂的运算
    public int f4(int a,int n){
        int res=a;
        int ex=1;
        if (n==0) return 1;
        while ((ex<<1)<=n){
            res=res*res;
            ex=ex<<1;
        }
        return res*f4(a,n-ex);


    }
}
