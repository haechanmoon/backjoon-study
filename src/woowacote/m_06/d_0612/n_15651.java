package woowacote.m_06.d_0612;

/*
sudo 코드 작성

int 배열선언
boolean 배열 선언

N과M을 받음

int배열 N개 생성
boolean배열 M개 생성

backtracking(0)

지금위치가 어디인지 계산을 해야해.
*/


import java.util.Scanner;

public class n_15651 {

    static int N, M;
    static int[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        selected = new int[M];
        backtracking(0);
    }

    private static void backtracking(int length) {
        if (length == M) {
            print();
            return;
        }
        for (int i = 0; i < N; i++) {
            selected[length] = i;
            backtracking(length + 1);
        }
    }

    private static void print() {
        for (int i = 0; i < M; i++) {
            System.out.print(selected[i] + 1 + " ");
        }
        System.out.println();
    }
}
