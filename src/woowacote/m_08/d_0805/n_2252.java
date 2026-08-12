package woowacote.m_08.d_0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//동해물과
/*
줄 세우기
어떻게 하면 키순서로 잘 세울 수 있을까? 에 대한 문제.
 */
public class n_2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            arr[i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);

            arr[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            sb.append(currentNode).append(" ");
            for (int value : graph[currentNode]) {
                arr[value]--;
                if (arr[value] == 0) {
                    queue.add(value);
                }
            }
        }
        System.out.println(sb);
    }
}
