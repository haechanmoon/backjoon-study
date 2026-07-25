package woowacote.m_07.d_0722;

/*
물의 양 구하기
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class n_2251 {

    private static ArrayList<Integer>[] arr;
    private static boolean[] visited;
    private static int[] abc, cur;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        abc = new int[3];
        visited = new boolean[3];
        for (int i = 0; i < 3; i++) {
            abc[i] = sc.nextInt();
        }
        cur = new int[3];
        cur[2] = abc[2];

    }
}
