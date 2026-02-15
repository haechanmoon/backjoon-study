import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        String stone = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int kx = king.charAt(0) - 'A';
        int ky = king.charAt(1) - '1';
        int sx = stone.charAt(0) - 'A';
        int sy = stone.charAt(1) - '1';

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            int dx = 0;
            int dy = 0;

            switch (cmd) {
                case "R": dx = 1; break;
                case "L": dx = -1; break;
                case "B": dy = -1; break;
                case "T": dy = 1; break;
                case "RT": dx = 1; dy = 1; break;
                case "LT": dx = -1; dy = 1; break;
                case "RB": dx = 1; dy = -1; break;
                case "LB": dx = -1; dy = -1; break;
            }

            int nkx = kx + dx;
            int nky = ky + dy;

            if (nkx < 0 || nkx >= 8 || nky < 0 || nky >= 8) continue;

            if (nkx == sx && nky == sy) {
                int nsx = sx + dx;
                int nsy = sy + dy;

                if (nsx < 0 || nsx >= 8 || nsy < 0 || nsy >= 8) continue;

                sx = nsx;
                sy = nsy;
            }

            kx = nkx;
            ky = nky;
        }

        System.out.println((char) (kx + 'A') + "" + (char) (ky + '1'));
        System.out.println((char) (sx + 'A') + "" + (char) (sy + '1'));
    }
}