package woowacote.d_0623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_1920 {

    private static int N, M;
    private static int[] arrN, arrM;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        arrM = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrN);
        sb = new StringBuilder();
        for (int value : arrM) {
            if (hasValue(value)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static boolean hasValue(int value) {
        int start = 0;
        int end = N - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (value == arrN[mid]) {
                return true;
            } else if (value > arrN[mid]) {
                start = mid + 1;
            } else if (value < arrN[mid]) {
                end = mid - 1;
            }
        }
        return false;
    }
}
