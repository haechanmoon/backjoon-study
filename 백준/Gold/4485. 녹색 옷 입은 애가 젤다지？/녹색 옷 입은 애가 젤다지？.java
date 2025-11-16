/*
자. 이거는 일단 필요한거는 PriorityQueue가 필요하다
와 설계, 구현하는거 진짜 빡세다.
자. 일단 다익스트라 알고리즘을 만드는거야.해보자.
 */

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int size;
    private static int[][] map;
    private static StringBuilder sb;
    private static boolean[][] flag;
    private static BufferedReader br;
    private static int[]dx = {0,0,1,-1};
    private static int[]dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int problemNum = 1;

        while(true){
            size = Integer.parseInt(br.readLine());

            if(size ==0){
                break;
            }

            map = new int[size][size];
            for(int i =0;i<size;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0;j<size;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = bfs();

            sb.append("Problem ").append(problemNum++).append(": ").append(result).append("\n");
        }
        System.out.print(sb);
    }

    public static int bfs(){
        int[][] minCost = new int[size][size];

        for(int i =0;i<size;i++){
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        minCost[0][0] = map[0][0];
        pq.add(new Node(0,0, map[0][0]));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int y = current.y;
            int x = current.x;

            if(current.cost>minCost[y][x]){
                continue;
            }

            for(int i = 0;i<4;i++){
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if(nextY<0||nextY>=size||nextX<0||nextX>=size){
                    continue;
                }

                int newCost = current.cost + map[nextY][nextX];

                if(newCost < minCost[nextY][nextX]){
                    minCost[nextY][nextX] = newCost;
                    pq.add(new Node(nextY, nextX, newCost));
                }
            }
        }
        return minCost[size-1][size-1];

    }

}

class Node implements Comparable<Node>{
    int y;
    int x;
    int cost;

    public Node(int y,int x,int cost){
        this.y = y;
        this.x = x;
        this.cost = cost;
    }
    
    public int compareTo(Node other){
        return this.cost - other.cost;
    }
}


