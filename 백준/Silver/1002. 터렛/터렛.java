import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            System.out.println(solve(x1, y1, r1, x2, y2, r2));
        }
    }

    private static int solve(int x1, int y1, int r1, int x2, int y2, int r2) {
        // 두 중심점 사이의 거리의 제곱 (루트를 씌우면 오차가 생길 수 있어 제곱으로 비교)
        int distanceSq = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // 1. 두 원이 완전히 일치하는 경우 (무한대)
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }
        // 2. 두 원의 중심이 같지만 반지름이 다른 경우 (만나지 않음)
        else if (x1 == x2 && y1 == y2) {
            return 0;
        }
        // 3. 외접하거나 내접하는 경우 (교점 1개)
        else if (distanceSq == Math.pow(r1 + r2, 2) || distanceSq == Math.pow(r1 - r2, 2)) {
            return 1;
        }
        // 4. 두 점에서 만나는 경우
        else if (Math.pow(r1 - r2, 2) < distanceSq && distanceSq < Math.pow(r1 + r2, 2)) {
            return 2;
        }
        // 5. 그 외 (만나지 않음)
        else {
            return 0;
        }
    }
}