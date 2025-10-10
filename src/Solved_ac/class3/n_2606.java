package Solved_ac.class3;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
진짜 이제 DFS, WFS 시작이네.
이거 언제나오나했어.
자. 빨리 하고 졸작 하러 가봐야지. Spring 오늘 30분이라도 하자!
*/
public class n_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        for (int i =0; i<M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(v).add(u);
            graph.get(u).add(v);
        }
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N+1]; //컴퓨터 번호와 인덱스 맞추기

        int count = 0;

        que.add(1);
        visited[1] = true;

        while (!que.isEmpty()){
            int currentComputer = que.poll(); //큐에서 현재 탐색할 컴퓨터를 하나 꺼냄.

            for (int friend : graph.get(currentComputer)){
                if(!visited[friend]){
                    visited[friend] = true;
                    que.add(friend);
                    count++;
                }
            }
        }

        System.out.print(count);
    }

}
