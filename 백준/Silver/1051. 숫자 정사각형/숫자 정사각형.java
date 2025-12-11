/*
자. 이거 흠. 어렵네. 배열을 이용하는가장 대표적인문제.
어떻게 풀어나가는게좋을까? 1시간 이내로 구현해보자.
일단 배열에서 같은 수가 있는지 찾는다.
그 수를 길이만큼 아래로 내려가서 있는지 확인.
오! 정사각형을 찾았다? => 넓이 구하고 갱신.
그렇게 하고 최댓값 갱신해나가면될듯?
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int len = Math.min(N, M);

        while (len > 1) {
            for (int i = 0; i <= N - len; i++) {
                for (int j = 0; j <= M - len; j++) {
                    char target = map[i][j];

                    if (target == map[i][j + len - 1] &&
                            target == map[i + len - 1][j] &&
                            target == map[i + len - 1][j + len - 1]) {

                        System.out.println(len * len);
                        return;
                    }
                }
            }
            len--;
        }

        System.out.println(1);
    }
}