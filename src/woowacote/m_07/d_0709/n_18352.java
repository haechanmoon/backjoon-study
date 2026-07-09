package woowacote.m_07.d_0709;

/*
여기서부터는 이제 그래프네.기
자 ~! 가봅시다. 일단 개념공부 부터 ㄱㄱ 근데 그래프 뭐 별거 없지 않나? 그냥 인접리스트에 넣고 돌리는거 아녀?
Arrays<Integer>[] 뭐 이런느낌이었던 것 같은데말이야.
어 이거 알았어. 그래프 구하는 법이 3개가 있네. 엣지 리스트, 인접 행렬, 인접 리스트
근데 엣지리스트는 거의 잘 안쓸 것 같긴한데? 엣지 리스트는 뭐 그런게 있다 정도 생각하면 될 것 같고말이야.
그냥 인접 리스트 쓰는게 제일 좋을듯? ㄱㄱ

최단거리가 K인 도시를 구하는것이니. 인접리스트 만들어놓고 . 근데 이거 BFS로 하는게 맞는것같다. depth가 K인 것을 구하는
것이니까 말이야.근데 구체적인 코드는 음.. 감이 잘 오지 않는데 일단 머리 박으면서 해볼게요
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n_18352 {

    static int cityCount, roadCount, distance, startCity;
    static ArrayList<Integer>[] arr;
    static int[] visited;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cityCount = Integer.parseInt(st.nextToken());
        roadCount = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());
        startCity = Integer.parseInt(st.nextToken());
        arr = new ArrayList[cityCount + 1];
        visited = new int[cityCount + 1];
        Arrays.fill(visited, -1);
        answer = new ArrayList<>();

        for (int i = 1; i <= roadCount; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < roadCount; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u].add(v);
        }
        bfs(startCity);
        for (int i = 0; i <= cityCount; i++) {
            if (visited[i] == distance) {
                answer.add(i);
            }
        }
        if (answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for (int value : answer) {
                System.out.println(value);
            }
        }
    }

    private static void bfs(int node) {
        Queue<Integer> que = new LinkedList<>();
        que.add(node);

        visited[node] = 0;
        while (!que.isEmpty()) {
            int currentNode = que.poll();
            for (int i : arr[currentNode]) {
                if (visited[i] == -1) {
                    visited[i] = visited[currentNode] + 1;
                    que.add(i);
                }
            }
        }
    }
}
