package woowacote.m_08.d_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n_1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] parent = new int[N + 1];
        int[] builtTime = new int[N + 1];
        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            builtTime[i] = u;
            while (true) {
                int a = Integer.parseInt(st.nextToken());
                if (a == -1) {
                    break;
                }
                graph[a].add(i);
                parent[i]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int value : parent) {
                if (value == 0) {
                    queue.add(value);
                }
            }
            while (!queue.isEmpty()) {
                int a = queue.poll();
            }
        }

    }
}
