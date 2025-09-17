package Solved_ac.class2;

import java.util.Scanner;
import java.util.Arrays;

public class n_2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = sc.nextInt();
        Arrays.sort(A);

        int best = 0;

        outer:
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = A[i] + A[j] + A[k];
                    if (sum > M) {
                        // 정렬되어 있으니 k를 더 키워봐야 합만 더 커짐
                        break;
                    }
                    if (sum > best) best = sum;
                    if (best == M) { // 최적 합 찾음
                        break outer;
                    }
                }
            }
        }
        System.out.println(best);
    }
}
