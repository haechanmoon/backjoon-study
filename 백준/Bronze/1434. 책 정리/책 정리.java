import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int totalBox = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            totalBox += Integer.parseInt(st.nextToken());
        }

        int totalBook = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            totalBook += Integer.parseInt(st.nextToken());
        }

        System.out.println(totalBox - totalBook);
    }
}