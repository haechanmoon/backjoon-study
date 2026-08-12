package woowacote.m_08.d_0810;

/*
게임 개발하기

일단 건물 N 개 받고
그 다음줄에는 1번이니까. 일단 그거 받아야될듯?
첫번째 토큰은 배열을 더해야해.
그다음에는 -1이 아니면 필요한 건물 번호가 들어가는거니까 graph에 넣어야겠지?
그렇게 하고나면 끝인듯?
근데 그래프에 들어가는게 반대여야해.
그리고 isVisited도 넣어야할듯? 그다음에 result배열도 있어야겠따. 가보자~ que도 있어야해.
 */

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

        boolean[] isVisited = new boolean[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] parent = new int[N + 1];
        int[] builtTime = new int[N + 1];
        int[] result = new int[N + 1];
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); //짓는데 걸리는 시간
            builtTime[i] = u;
            int v = Integer.parseInt(st.nextToken());
            while (v != -1) {
                graph[v].add(i);
                parent[i]++;
                v = Integer.parseInt(st.nextToken());
            }
        }
        for (int value : parent) {
            if (value == 0) {
                queue.add(value);
            } else {
                queue.add(1);
            }
        }

        while (!queue.isEmpty()) {
            int a = queue.poll();
            if (!isVisited[a]) {
                isVisited[a] = true;
            }

        }
    }

}
