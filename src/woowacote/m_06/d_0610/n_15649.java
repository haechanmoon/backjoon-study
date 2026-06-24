package woowacote.m_06.d_0610;

/*
흠. 이거는 진짜 어떻게 푸는지를 모르겠네...
자. 가보자.

N,M 하고
V, S backtracking Legend

백트래킹실행(수열 길이)
if(길이가 M인 수열이 만들어진 경우){
    수열 끝
for(1~N탐색){
    아직 수열없으면
        V배열에 수 표시
        수열 추가
        수열 1증가 후 backtracking 또 실행
        V배열에 수 사용 표시 제거
 */


import java.util.Scanner;

public class n_15649 {
    //백트래킹이다.
    private static int N, M;
    private static boolean[] V;
    private static int[] S;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        S = new int[N];
        V = new boolean[N];
        backtracking(0);
    }

    private static void backtracking(int length) {
        if (length == M) {
            printArray();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!V[i]) {
                V[i] = true;
                S[length] = i;
                backtracking(length + 1);
                V[i] = false;
            }
        }
    }

    private static void printArray() {
        for (int i = 0; i < M; i++) {
            System.out.print(S[i] + 1 + " ");
        }
        System.out.println();
    }
}
