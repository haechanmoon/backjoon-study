import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] rowHasGuard = new boolean[N];
        boolean[] colHasGuard = new boolean[M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'X') {
                    rowHasGuard[i] = true;
                    colHasGuard[j] = true;
                }
            }
        }

        int rowCount = 0;
        for (boolean hasGuard : rowHasGuard) {
            if (!hasGuard) rowCount++;
        }

        int colCount = 0;
        for (boolean hasGuard : colHasGuard) {
            if (!hasGuard) colCount++;
        }

        System.out.println(Math.max(rowCount, colCount));
    }
}