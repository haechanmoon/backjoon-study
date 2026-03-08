import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 100) {
            System.out.println(N);
        } else {
            int count = 99;
            for (int i = 100; i <= N; i++) {
                if (i == 1000) break;
                
                int h = i / 100;
                int t = (i / 10) % 10;
                int o = i % 10;

                if ((h - t) == (t - o)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}