package woowacote.m_09.d_0930;

/*
이것은 어떻게 풀 것인가? 자 봐보자.

 */


import java.util.ArrayList;
import java.util.Scanner;

public class n_1414 {

    public static int N;
    public static ArrayList<Edge1001> edge1001s;
    public static boolean[] visited;
    public static int[][] board;
    public static Edge1001 edge1001;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String a = sc.next();
            for (int j = 0; j < N; j++) {
                int s = a.charAt(j);
                if (s > 96) {
                    s = s - 96;
                } else {
                    s = s - 64;
                }
                board[i][j] = s;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Edge1001 edge1001 = new Edge1001(i, j, board[i][j]);


            }
        }
    }


    public static class Edge1001 {

        private final int start;
        private final int end;
        private final int weight;

        Edge1001(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }


    }
}
