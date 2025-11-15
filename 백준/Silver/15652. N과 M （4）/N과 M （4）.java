/*
이거는 15650과 굉장히 유사한 문제.
어제 풀었던거를 아주 공부를 잘 할 수가 있겠어.
일단 어제 풀었던거 복기하면서 풀어볼까?
일단 main에서 dfs(1,0)돌린다.
그럼 dfs에서는 어떻게 하느냐.
combination[M] 을 만들고
combination[0]이 뭔지. [1] 이뭔지 [2]가 뭔지.. [M-1]이 뭔지.. 이런걸 알아야하잖아!
그거를 이제 재귀함수로 써먹는거야. start로 장난질 치는거지.
이제 depth가 M이랑 같아졌을 때 그거를 반환하는거야.


 */

import java.util.Scanner;

public class Main {
    private static int N, M;
    private static int[] combination;
    private static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        combination = new int[M]; // M칸짜리 바구니 생성
        sb = new StringBuilder();

        dfs(1, 0);
        System.out.print(sb);
    }

    public static void dfs(int start, int depth) {
        if (depth == M) {
            for (int val : combination) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            combination[depth] = i;
            dfs(i, depth + 1);
        }

    }
}
