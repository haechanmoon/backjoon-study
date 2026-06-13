package woowacote.d_0613;

/*
1. 중복허용 2. 비내림차순(오름차순인데 같은게 올수도 있어서 이렇게 한듯) 자. ~ 가보자

M,N, boolean[], int[] 만들어줘야함.
일단. 다 만들고 backtracking(length=0, 시작=0) 이렇게 시작을 해.
백트래킹 안에서 어떤일이 벌어지느냐?
1. 만약 (length가 M이라면?){
        print()하고 끝내야지.}
2. 일단 for(시작부터N까지){
            int[depth]에 시작을 넣어
            backtracking(depth+1, 시작)
3. 이걸 출력해줌. 솔직히 뭐 별거 없죠? 와. 근데 for문을 이제 진짜 이해를 해버렸다.
 */


import java.io.IOException;
import java.util.Scanner;

public class n_15652 {

    private static StringBuilder sb;
    private static int N, M;
    private static int[] answers;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        answers = new int[M];
        sb = new StringBuilder();
        backtracking(0, 1);
        System.out.print(sb);
    }

    private static void backtracking(int depth, int startAt) {
        if (depth == M) {
            for (int answer : answers) {
                sb.append(answer).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = startAt; i <= N; i++) {
            answers[depth] = i;
            backtracking(depth + 1, i);
        }
    }
}
