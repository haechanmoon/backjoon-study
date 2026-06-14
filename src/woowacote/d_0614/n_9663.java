package woowacote.d_0614;

import java.util.Scanner;

/*
N queen 자 가보자~~!
흠. 일단. 문제를 분석해보자. 일단 그냥 하나당 루트에 안겹치게 하는게 제일 중요할 것 같아.
경우의 수가 몇개가 있을까? 결국에는 백트래킹 문제인데말이야. 흠...
일단. 퀸의 갈 수 있는 경로를 다 파악을 해야하나? 진짜 도무지 흠. 어떻게 풀 지 감이 안오네
퀸의 말을 어디로 갈 수 있는지 푸는게 굉장히 어렵다. 일단 이차원배열을 두는 게 좋은 것 같은데?
일단 구현을 하는게 중요한 게 아니라 설계를 먼저 잘 잡고 가는게 좋을 것 같은데 그게 너무 안되네.
일단. 아주 좋은 인사이트를 얻었어. 2차원배열을 1차원으로 사용이 가능한점. 그리고 절댓값을 이용하여 대각선을 구할
수 있다는 점. 여기서 좋은 것 같다. 수도 작성해보자.

** SUDO 코드
static에 int[], N, count
N받음.
배열을 N개 만들어.
backtracking(0)실행.

backtracking에는
for(0<=N)
    if(int[i])가 비어있다면?
    int[i] =
 */
public class n_9663 {

    private static int N, count;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        count = 0;
        arr = new int[N];

        backtracking(0);
        System.out.print(count);
    }

    private static void backtracking(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (check(depth, i)) {
                arr[depth] = i;
                backtracking(depth + 1);
            }
        }
    }

    private static boolean check(int depth, int value) {
        for (int i = 0; i < depth; i++) {
            if (arr[i] == value) {
                return false;
            }
            if (Math.abs(depth - i) == Math.abs(value - arr[i])) {
                return false;
            }
        }

        return true;
    }
}
