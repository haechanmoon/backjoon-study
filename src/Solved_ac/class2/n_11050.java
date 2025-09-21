package Solved_ac.class2;

import java.util.Scanner;

public class n_11050 {
    public static int factorial(int n){
        if(n<=1) return 1;
        else return n * factorial(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int result = factorial(N)/(factorial(M)*factorial(N-M));
        System.out.println(result);
    }
}
