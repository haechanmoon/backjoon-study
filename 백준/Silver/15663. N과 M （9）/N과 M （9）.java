import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] result;
    private static int[] basket;
    private static boolean[] visited;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        basket = new int[N];
        result = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            basket[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(basket);

        dfs(0);
        System.out.print(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;

        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            if(before != basket[i]){
                visited[i] = true;
                result[depth] = basket[i];
                before = basket[i];
                dfs(depth+1);
                visited[i] = false;

            }
        }
    }
}
