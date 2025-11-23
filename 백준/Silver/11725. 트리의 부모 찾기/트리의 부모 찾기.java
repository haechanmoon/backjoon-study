/*
자. 이건 완전히 트리를 이용한 문제구만! 트리는 어떻게표현하는것일까?
음..내가봤을때 Queue?Stack?뭐 이런거 쓰는것같았는데..하. 기억이 솔직히 잘 나진 않네.
어떻게 풀어야할까!LinkedList?
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i =0;i<=N;i++){
            tree.add(new ArrayList<>());
        }

        for(int i =0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int[] parents = new int[N+1];
        boolean[] visited = new boolean[N+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()){
            int current = queue.poll();
            for(int next: tree.get(current)){
                if(!visited[next]){
                    visited[next] = true;
                    parents[next] = current;
                    queue.add(next);
                }
            }
        }
        for(int i =2;i<=N;i++){
            sb.append(parents[i]).append("\n");
        }
        System.out.print(sb);
    }
}
