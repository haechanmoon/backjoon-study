/*
뒤통수 맞았네. 와. 이거 뭐냐진짜? 아니 진짜 어이가 없네.
이차원배열로 열심히 풀었는데 하...힘드네.이거. 왜이렇게 어렵냐..


import java.io.*;
import java.util.StringTokenizer;

public class n_14719 {
    private static boolean[][] originalBox;
    private static int width, height;
    private static BufferedReader br;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        originalBox = new boolean[height][width];
        boolean[][] copyBox = originalBox;

        for (int i = 0; i < width; i++) {
            st = new StringTokenizer(br.readLine());//일단 받아. 그리고 아래에서부터 채워야하잖아.
            int blockHeight = Integer.parseInt(st.nextToken());
            for (int j = height; j > (height - blockHeight); j--) {
                originalBox[j][i] = true;
            }
        }
        //일단 블록은만들어놨어. 이제 while로 돌려야겠다.
        rain(width, height, originalBox);


    }

    public static int rain(int width, int height, boolean[][] originalBox) {
        int check = 0;
        int rainCount = 0;

        for (int j = height; j > 0; j--) {
            for (int i = 0; i < width; i++) {
                if(originalBox[j][i]){
                    check++;
                }
            }
        }
    }
}

 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken()); // 높이
        int W = Integer.parseInt(st.nextToken()); // 가로

        // 1. 1차원 배열로 블록 높이 저장
        int[] heights = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int totalRain = 0;

        for (int i = 1; i < W - 1; i++) {
            int maxLeft = 0;
            for (int j = 0; j < i; j++) {
                maxLeft = Math.max(maxLeft, heights[j]);
            }

            int maxRight = 0;
            for (int j = i + 1; j < W; j++) {
                maxRight = Math.max(maxRight, heights[j]);
            }
            int waterHeight = Math.min(maxLeft, maxRight);
            if (waterHeight > heights[i]) {
                totalRain += (waterHeight - heights[i]);
            }
        }
        System.out.println(totalRain);
    }
}
