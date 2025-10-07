package Solved_ac.class3;
/*
 * 알고리즘을 한번 짜 볼까? 3
 * 일단 이건 좀 쉬운편인거같긴한데?
 * 줄을 세우는데 일단 제일 적게걸리는순으로 오름차순 세우고.
 * 1번 +1,2 + 1,2,3 + 1,2,3,4 뭐 이런느낌으로
 * 시간제한이 1초라...
 * 필요한것들. BufferedReader/ StringTokenizer/ StringBuilder/ for문/ int 변수들.
 * 이건 직접 해볼 만 하겠는데?
 *
 * */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] total = new int[N];
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(st.nextToken());
            total[i] = M;
        }
        Arrays.sort(total);

        int totalWait = 0;
        int thisWait = 0;
        int[] nowWait = new int[N];

        for(int i = 0; i<N ; i++){
            thisWait += total[i];
            nowWait[i] = thisWait;
            totalWait += nowWait[i];
        }
        System.out.println(totalWait);
    }
}
