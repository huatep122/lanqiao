package HDOJ.recursion;
import java.util.Scanner;

public class p2013 {
    public static int solution(int dayCount){
        if (dayCount==1) return 1;
        return 2*solution(dayCount-1)+2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(solution(scanner.nextInt()));
        }
    }
}
