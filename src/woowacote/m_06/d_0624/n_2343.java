package woowacote.m_06.d_0624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (start < arr[i]) {
                start = arr[i];
            }
            end += arr[i];
        }
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 1;

            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    count++;
                    sum = arr[i];
                } else {
                    sum += arr[i];
                }
            }
            if (count > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
                result = mid;
            }
        }
        System.out.print(result);
    }
}
