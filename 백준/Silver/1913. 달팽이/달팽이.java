/*
이건 뭘 푸는 문제일까? 자. 한번 해보자!
구현인데.. 이차원배열을 무조건 써야하구만!
일단 중앙에 하나 찍고
그 나선형으로 돌아가면서 숫자를 찍는건데. 이거를 어떻게 하면 좋을까나
머리좀 써야겠군. 1부터 찍는거보단 마지막수자를 넣는게 더 빨라보인다.
방향을 잡는 문제들 많이 풀어봤지만 항상 어려웠던 것 같음. 뭐 이게 기초인데 어쩔수 없지. 
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int num = N * N;

        int r = 0;
        int c = 0;
        int dir = 0;

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int targetR = 0;
        int targetC = 0;

        while (num > 0) {
            map[r][c] = num;

            if (num == target) {
                targetR = r + 1;
                targetC = c + 1;
            }

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] != 0) {
                dir = (dir + 1) % 4;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }

            r = nr;
            c = nc;
            num--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(targetR).append(" ").append(targetC);

        System.out.println(sb);
    }
}