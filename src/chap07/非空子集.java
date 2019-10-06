package chap07;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class 非空子集 {
    @Test
    public void test1(){
        String[] strings = {"a","b","c"};
        Set<Set<String>> sets = f(2, strings);
        Set<String> nil = new HashSet<>();
        sets.remove(nil);
        for (Set<String> s:
             sets) {
            System.out.print(s);
        }
    }
    //递归形式
    private Set<Set<String>> f(int n, String[] strs) {
        Set<Set<String>> newSet = new HashSet<>();
        if (n==0){
            Set<String> nil = new HashSet<>();
            Set<String> first = new HashSet<>();
            newSet.add(nil);
            first.add(strs[0]);
            newSet.add(first);
            return newSet;
        }
        Set<Set<String>> set = f(n - 1, strs);
        for (Set<String> s:
             set) {
            newSet.add(s);
            Set<String> clone = (Set<String>) ((HashSet) s).clone();
            clone.add(strs[n]);
            newSet.add(clone);
        }
        return newSet;
    }

    @Test
    //迭代形式
    public void test2(){
        String[] strings = {"a","b","c"};
        HashSet<HashSet<String>> resSet = new HashSet<>();
        resSet.add(new HashSet<>());
        for (int i = 0; i < strings.length; i++) {
            HashSet<HashSet<String>> curSet = (HashSet<HashSet<String>>) resSet.clone();
            for (Set<String> s:
                 curSet) {
                HashSet<String> s_ = (HashSet<String>) ((HashSet)s).clone();
                s_.add(strings[i]);
                resSet.add(s_);
            }
        }
        System.out.println(resSet);
    }

    
    @Test
    //二进制方法
    public void test3(){

    }
}
