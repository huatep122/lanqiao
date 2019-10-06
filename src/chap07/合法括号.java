package chap07;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;

public class 合法括号 {
    @Test
    //迭代形式
    public void test1(){
        HashSet<String> set = f(3);
        for (String s:set) {
            System.out.print(s+" ");
        }
    }
    private HashSet<String> f(int n) {
        HashSet<String> set= new HashSet<>();
        set.add("()");
        if (n==1)
            return set;
        else {
            HashSet<String> oldSet = set;
            HashSet<String> newSet = new HashSet<>();
            for (int i = 1; i < n; i++) {
                for (String s:oldSet) {
                    newSet.add("()"+s);
                    newSet.add(s+"()");
                    newSet.add("("+s+")");
                }
                oldSet = (HashSet<String>) newSet.clone();
                newSet.clear();
            }
            return oldSet;
        }
    }

    @Test
    public void test2(){
        Set<String> set = f2(3);
        for (String s:
             set) {
            System.out.println(s);
        }
    }

    private Set<String> f2(int n) {
        Set<String> set = new HashSet<>();
        if (n==1){
            set.add("()");
            return set;
        }
        Set<String> oldSet = f2(n - 1);
        for (String s :
                oldSet) {
            set.add("()"+s);
            set.add(s+"()");
            set.add("("+s+")");
        }
        return set;
    }

}
