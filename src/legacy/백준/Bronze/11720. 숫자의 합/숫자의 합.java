import java.util.Scanner;

/*
아 이거 실수하기 쉽다. sc.next와 sc.nextLine()에 대해서 더 잘 알아야할듯. 
*/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String input = sc.next();
        int sum =0 ;
        for(char val : input.toCharArray()){
            sum+=val-'0';
        }
        System.out.println(sum);
    }
}
