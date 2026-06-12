package woowacote.d_0611;

/*
일단 N과 M을 받아서
수열의 개수는 M개가 되겠고
불리언은 N개가 되겠죠!

그리고 이제시작을 하는거야.
일단. 세팅을 쫙 해놔. 그리고 출력하는 폼도 만들면 좋겠네.흠. 이제 어떻게 하냐면 일단 현재 배열을 하나씩 채우는 과정이야


 */

import java.util.Scanner;

public class n_15650 {
    static int[] arr;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        backtracking(0, 1);
    }

    private static void backtracking(int length, int start) {
        if (length == M) {
            printArray();
            return;
        }
        for (int i = start; i <= N; i++) {
            arr[length] = i;
            backtracking(length + 1, i + 1);
        }
    }

    private static void printArray() {
        for (int i = 0; i < M; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
