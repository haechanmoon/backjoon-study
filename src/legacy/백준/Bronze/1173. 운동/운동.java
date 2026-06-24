import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int res = 0;
        int move = 0;
        int curr = m;

        if (m + T > M) {
            System.out.println(-1);
            return;
        }

        while (move < N) {
            res++;

            if (curr + T <= M) {
                curr += T;
                move++;
            } else {
                curr -= R;
                if (curr < m) {
                    curr = m;
                }
            }
        }

        System.out.println(res);
    }
}
