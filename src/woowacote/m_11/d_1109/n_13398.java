package woowacote.m_11.d_1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // keep[i]: i에서 끝나며, 수를 제거하지 않은 최대 연속합
        int[] keep = new int[N + 1];
        // removed[i]: i까지 이어지는 구간에서 수 하나를 제거한 최대 연속합
        int[] removed = new int[N + 1];
        keep[1] = arr[1];
        // 첫 수만 제거한 빈 초기 상태는 정답 후보에 넣지 않는다.
        removed[1] = 0;
        int answer = arr[1];

        for (int i = 2; i <= N; i++) {
            keep[i] = Math.max(arr[i], keep[i - 1] + arr[i]);
            // 현재 수를 제거하거나, 앞에서 이미 제거한 구간에 현재 수를 붙인다.
            removed[i] = Math.max(keep[i - 1], removed[i - 1] + arr[i]);
            answer = Math.max(answer, Math.max(keep[i], removed[i]));
        }
        System.out.print(answer);
    }
}
