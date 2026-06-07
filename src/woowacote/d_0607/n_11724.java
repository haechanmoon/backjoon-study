package woowacote.d_0607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
자. 이거는 연결요소 구하는거야. 아니 이거 할만 하지 않나? 괜찮잖아. 솔직히.
일단. main위에 배열 2개 놓고 말이야. 거기서 훅훅돌리면되잖아. ㅇㅋ? ㄱㄱ
 */

public class n_11724 {

    static ArrayList<Integer>[] graph;
    static boolean[] flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        flag = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!flag[i]) {
                count++;
                dsf(i);
            }
        }

        System.out.println(count);
    }

    private static void dsf(int node) {
        flag[node] = true;
        for (int next : graph[node]) {
            if (!flag[next]) {
                dsf(next);
            }
        }
    }
}
