import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minPackage = 1001;
        int minSingle = 1001;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            minPackage = Math.min(minPackage, Integer.parseInt(st.nextToken()));
            minSingle = Math.min(minSingle, Integer.parseInt(st.nextToken()));
        }
        minPackage = Math.min(minPackage, minSingle * 6);
        int result = 0;
        result = Math.min(((N / 6) * minPackage) + ((N % 6) * minSingle), ((N / 6) + 1) * minPackage);
        result = Math.min(result, N * minSingle);

        System.out.println(result);
    }
}