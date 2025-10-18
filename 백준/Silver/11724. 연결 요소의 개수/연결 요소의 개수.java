/*
1. 입력받기
    @- BufferedReader와 StringTokenizer이용하여 N과 M을 읽기
    - 그래프 저장할 인접리스트 생성 ArrayList<ArrayList<Integer>> graph). N+1 크기로 생성. 0자리 비우기
    - 방문여부 체크할 boolean[] visited 배열을 N+1 크기로 만든 후 false로 초기화
    - N번 반복 후 u,v 양방향 저장. graph.get(u).add(v) ---- graph.get(v).add(u)

2. 연결 요소 세기
    - componentCount 0으로 초기화
    - for문을 1부터 N까지 돌면서 각 정점 확인
        - if(!visited[i]) : false면 새로운 연결요소 발견
            - componentCount++
            - bfs() i번 부터 시작하는 모든 정점 찾아 visited를 true로 변경

3. BFS 함수 구현(Graph Traversal)
    - bfs 생성
    - Queue<Integer> queue
    - queue.add(startNode) 하고 visited[startNode] = true로 변경
    - while (!queue.isEmpty()) 루프 돈다.
        - int currentNode = queue.poll();
        - for(int neighbor : graph.get(currentNode))로 현재 노드의 모든 이웃 확인
        - if(!visited[neighbor])
            -visited[neighbor] = true로 바꿈.
            -queue.add(neighbor) 로 큐에 추가.

4. 출력
    - componentCount를 출력
 */

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i =0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[N+1]; //자동으로 false로 등록!

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int componentCount = 0;

        for(int i =1;i<=N;i++){
            if(!visited[i]){
                componentCount++;
                bfs(i,visited,graph);
            }
        }
        System.out.print(componentCount);
    }
    public static void bfs(int startNode, boolean[] visited, ArrayList<ArrayList<Integer>> graph){
        Queue<Integer> que = new LinkedList<>();
        que.add(startNode);
        visited[startNode] = true;

        while(!que.isEmpty()){
            int currentNode = que.poll();
            for(int neighbor: graph.get(currentNode)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    que.add(neighbor);
                }
            }
        }
    }

}
