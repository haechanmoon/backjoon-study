package woowacote.m_06.d_0615;

/*
N과 M을 받음
int[] 수열을 일단 받음 sort로 정렬 한 뒤 넣어주는게 좋겠죠?
backtracking(0,arr[1])을 넘겨주면 될 것 같은데? 이거 솔직히 막 엄청 어렵진 않을 것 같음.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_15654 {

    private static int N, M;
    private static int[] arr;
    private static int[] result;
    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        sb = new StringBuilder();
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backtracking(0);
        System.out.print(sb);
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            for (int a : result) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
