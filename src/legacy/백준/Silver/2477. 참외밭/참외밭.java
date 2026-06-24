import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int[] lens = new int[6];
        int maxW = 0, maxWIdx = 0;
        int maxH = 0, maxHIdx = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            lens[i] = len;

            if (dir == 1 || dir == 2) {
                if (len > maxW) {
                    maxW = len;
                    maxWIdx = i;
                }
            } else {
                if (len > maxH) {
                    maxH = len;
                    maxHIdx = i;
                }
            }
        }

        int minW = lens[(maxWIdx + 3) % 6];
        int minH = lens[(maxHIdx + 3) % 6];

        int area = (maxW * maxH) - (minW * minH);
        System.out.println(area * K);
    }
}