import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] score = new double[N];
        for(int i =0 ; i<N;i++){
            score[i] = sc.nextInt();
        }
        double maxScore =0 ;
        for(int i =0 ;i<N;i++){
            if(maxScore<score[i]){
                maxScore = score[i];
            }
        }
        for(int i =0 ; i<N;i++){
            score[i] = score[i]/maxScore*100;
        }
        double total = 0 ;
        for(int i = 0 ; i<N;i++){
            total+=score[i];
        }
        System.out.println(total/N);
    }
}
