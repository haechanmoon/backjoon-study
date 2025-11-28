import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int minH = 256;
        int maxH = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] < minH) minH = map[i][j];
                if (map[i][j] > maxH) maxH = map[i][j];
            }
        }

        int minTime = Integer.MAX_VALUE;
        int finalHeight = 0;

        for (int h = minH; h <= maxH; h++) {
            int removeCount = 0;
            int addCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > h) {
                        removeCount += (map[i][j] - h);
                    } else {
                        addCount += (h - map[i][j]);
                    }
                }
            }

            if (B + removeCount >= addCount) {
                int time = (removeCount * 2) + addCount;
                
                if (time <= minTime) {
                    minTime = time;
                    finalHeight = h;
                }
            }
        }

        System.out.println(minTime + " " + finalHeight);
    }
}