package woowacote.d_0619;

/*

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n_2178 {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int N, M, result, value;
    private static int[][] board;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        bfs(0, 0);
        System.out.println(board[N - 1][M - 1]);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{i, j});
        result = Math.min(result, value);
        visited[i][j] = true;
        if (i == N && j == M) {
            return;
        }

        Queue<int[][]> que = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            if (board[x + dx[i]][y + dy[i]] == 1) {
                que.add()
            }
        }

    }
}


