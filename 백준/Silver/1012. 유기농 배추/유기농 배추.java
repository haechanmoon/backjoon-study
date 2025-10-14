/*이거는 충분히 풀 수 있겠는데?
일단 M,N 2차원배열만들고 그렇게 하는건가? 배추를 심고. K개 만큼.
x,y 좌표 주니까 배열만들어서 배추 심고. 0==>1로 바꿈.

그럼이제 지렁이 개수 구할때
0,0부터 쭉 가. 1을 만났어. 아! 이거 그래프 그건데. bfs. 주변에 1있으면 그거를 한묶음으로 처리하는거.
그거 개수 나열하면 되는거 아니야?
일단. 테스트케이스의 갯수도 신경 써야하겠군. 이건 충분히 짤 만한데?
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int T = Integer.parseInt(br.readLine()); //테스트 개수

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken()); //가로
            int N = Integer.parseInt(st.nextToken()); //세로
            int K = Integer.parseInt(st.nextToken()); //배추개수

            int[][] array = new int[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                array[y][x] = 1; //배추 심기 끝
            }

            int count = 0;
            boolean[][] visited = new boolean[N][M];

            Queue<Integer> que = new LinkedList<>();
            for (int p = 0; p < N; p++) {
                for (int q = 0; q < M; q++) {
                    if (array[p][q] == 1) {
                        count++;
                        bfs(array, p,q,N,M);

                    }
                }
            }

            sb.append(count).append("\n");
        } System.out.print(sb);

    }


    public static void bfs(int array[][], int startY, int startX, int N, int M) {
        Queue<int[]> que = new LinkedList<>();

        //상하좌우탐색 쉽게
        int[] dx = {0, 0, 1, -1}; // x의 이동방향(우,좌)
        int[] dy = {1, -1, 0, 0}; // y의 이동방향(상,하)

        que.add(new int[]{startY, startX});
        array[startY][startX] = 0;

        while (!que.isEmpty()) {
            int[] current = que.poll();
            int currentY = current[0];
            int currentX = current[1];

            // 꺼낸 곳의 상하좌우를 확인합니다.
            for (int i = 0; i < 4; i++) {
                int nextY = currentY + dy[i];
                int nextX = currentX + dx[i];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                    continue; // 벗어났으면 무시하고 다음 방향 확인
                }

                if (array[nextY][nextX] == 1) {
                    array[nextY][nextX] = 0; // 즉시 칠해버리고 (방문 표시)
                    que.add(new int[]{nextY, nextX}); // '다음에 칠할 곳' 목록에 추가
                }


            }
        }
    }

}
