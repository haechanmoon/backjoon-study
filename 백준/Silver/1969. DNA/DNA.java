/*
이거는 문자열 연습하기 딱 좋은것같은데?
일단 전체적으로 제일 많이 갖고 있는 문자를 그 위치에 배치한담에.
1번이랑 비교하고
2번이랑 비교하고
뭐 이런식으로 해나가면 별 어려움 없이 진행 할 수 있겠는데?
그리고 ACGT순으로 배열만들어서 숫자 올리면 쉽게 할 수 있을듯.
 */

import java.io.*;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] dnas = new String[N];
        for (int i = 0; i < N; i++) {
            dnas[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        int totalHammingDistance = 0;

        for (int j = 0; j < M; j++) {
            int[] count = new int[4];

            for (int i = 0; i < N; i++) {
                char ch = dnas[i].charAt(j);
                if (ch == 'A') {
                    count[0]++;
                } else if (ch == 'C') {
                    count[1]++;
                } else if (ch == 'G') {
                    count[2]++;
                } else if (ch == 'T') {
                    count[3]++;
                }
            }

            int maxIdx = 0;
            int maxCount = 0;

            for (int k = 0; k < 4; k++) {
                if (count[k] > maxCount) {
                    maxCount = count[k];
                    maxIdx = k;
                }
            }

            if (maxIdx == 0) {
                sb.append('A');
            } else if (maxIdx == 1) {
                sb.append('C');
            } else if (maxIdx == 2) {
                sb.append('G');
            } else {
                sb.append('T');
            }

            totalHammingDistance += (N - maxCount);
        }

        System.out.println(sb);
        System.out.println(totalHammingDistance);
    }
}