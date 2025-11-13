/*
이거 bfs로 풀면 좋을듯!!
근데이거 배열을 어떻게 받아야하지. 배열말고 collection을 쓰는게좋다는 말을 들어서.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[N][N];
        int[][] town = new int[N][N];

        for(int i =0;i<N;i++){
            String line = br.readLine();
            for(int j =0;j<N;j++){
            town[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> houseCounts = new ArrayList<>();
        int totalTowns = 0;

        for(int i = 0 ; i<N;i++){
            for(int j = 0 ; j<N;j++){
                if (town[i][j] == 1 && !visited[i][j]) {
                    totalTowns++;
                    int count = bfs(town, visited, i, j, N);
                    houseCounts.add(count);
                }
            }
        }

        Collections.sort(houseCounts);

        StringBuilder sb = new StringBuilder();
        sb.append(totalTowns).append("\n");
        for(int count : houseCounts){
            sb.append(count).append("\n");
        }
        System.out.print(sb);

    }

    public static int bfs(int[][] town, boolean[][] visited, int startY, int startX, int N){
        Queue<int[]> que = new LinkedList<>();
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        que.add (new int[]{startY,startX});
        visited[startY][startX] = true;
        int houseCount = 0;

        while (!que.isEmpty()){
            int[] current = que.poll();
            int y = current[0];
            int x = current[1];
            houseCount++;

            for(int i =0;i<4;i++){
                int ny = y+dy[i];
                int nx = x+dx[i];

                if(ny<0||ny>=N||nx<0||nx>=N){
                    continue;
                }
                if(town[ny][nx] ==1&& !visited[ny][nx]){
                    visited[ny][nx] = true;
                    que.add(new int[]{ny,nx});
                }
            }
        }

        return houseCount;
    }
}
