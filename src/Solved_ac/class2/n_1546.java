package Solved_ac.class2;

import java.util.Arrays;
import java.util.Scanner;

public class n_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
        }
        Arrays.sort(score);
        int topScore = score[N-1];
        int scoreSum = 0;
        for (int i = 0; i<N;i++){
            scoreSum += score[i];
        }
        double average = (double) scoreSum /N;
        double result = average /topScore*100;
        System.out.println(result);

    }
}