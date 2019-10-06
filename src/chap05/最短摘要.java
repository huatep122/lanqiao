package chap05;

import org.junit.jupiter.api.Test;


public class 最短摘要 {



    @Test
    public void test2(){
        String[] keywords={"a","b","c"};
        String[] str = {"c","c","c","a","c","b","c","a","a","a","b","c","a","c"};
        int[] flagCount = new int[keywords.length];
        int minLength=Integer.MAX_VALUE;
        int p1=0;
        int p2=-1;
        while (true){
            //p1开始前进找左边界
            while (p1<str.length || p1<p2){
                //p1现在所指向的不是关键字，直接后移p1
                if (!belongsTo(str[p1],keywords)) p1++;
                else {//p1指向了关键字，也就是找到了左边界
                    //记录关键字出现次数
                    if (flagCount[indexof(str[p1],keywords)]==0)
                        flagCount[indexof(str[p1],keywords)]++;
                    break;//找到左边界后，p1停止前进，直接退出p1的循环
                }
            }
            //p2开始前进找右边界
            if (p2==-1){//p2是第一次开始移动,直接从左边界的下一个开始，省的在左边浪费
                p2=p1+1;
            }
            while (p2<str.length){
                //p2所指不是关键字。后移指针
                if (!belongsTo(str[p2],keywords)) p2++;
                else {
                    //p2指向了关键字，先对关键字次数进行累加
                    flagCount[indexof(str[p2],keywords)]++;
                    //由于在左边界的右侧找到了一个关键字，那么有可能已经done了，进行判断
                    if (!isDone(flagCount)) p2++;//没有done说明还没找到右边界，继续前进寻找
                    else {
                        //找到了右边界。此时找到了整个范围，左边界p1，右边界p2，判断区间范围是否小于最小值
                        if (minLength>p2-p1+1)
                            minLength=p2-p1+1;
                        //无论是否更新了minLength，此时都完成了一个区间，之后要p1前进了，p2则保持不动
                        //p1前进之前把p1指向关键词次数减少一个，就是说这个新的p1p2区间少了一个关键字
                        flagCount[indexof(str[p1],keywords)]--;
                        flagCount[indexof(str[p2],keywords)]--;//因为p2不动。直到p1找到了新的边界才开始动，最差情况是和p2找到了重复的关键字，先不考虑。
                        // 但是下一次进入 循环后先进行了++操作，则会多进行一次计数
                        p1++;
                        break;
                    }
                }
            }
            if (p2==str.length) break;
        }
        System.out.println(minLength);
    }

    private boolean isDone(int[] flagCount) {
        for (int i = 0; i < flagCount.length; i++) {
            if (flagCount[i]==0) return false;
        }
        return true;
    }

    private int indexof(String word, String[] keywords) {
        for (int i = 0; i < keywords.length; i++) {
            if (keywords[i].equals(word)) return i;
        }
        return -1;
    }

    private boolean belongsTo(String word, String[] keywords) {
        for (int i = 0; i < keywords.length; i++) {
            if (word.equals(keywords[i])) return true;
        }
        return false;
    }


}
