/*
N과 M은 진짜 많이 보인다. 이거 약간 시리즈인가봐. 근데 나는 이거 진짜 못풀겠어. 이거 너무 어려워. 아무리 실버문제라지만
흠..내가 과연 풀 수 있을까? 나는 지금 실버1인데 이거 솔직히 너무 뻥튀기 된 것 같다. 나는 실버5가 맞는것같다.
일단. 뭐. 어떡하냐. 해봐야지

필요한 기술들 모아볼까?
1. 재귀
2. dfs
3. PriorityQueue
뭐이정도인것같은데?
일단 어떻게 돌아가는지를 알아야해.근데 N과 M 문제의 핵심은 백트랙킹이란 것을 알고는 있거든? 근데 막상 하려면 잘 안되더라고...


 */
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N,M;
    private static int[] result;
    private static int[] basket;
    private static boolean[] flag;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        result = new int[N];
        basket = new int[M];
        flag = new boolean[N];

        for(int i =0;i<N;i++){
            result[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(result);

        dfs(0);
        System.out.print(sb);

    }

    public static void dfs(int depth){
        if(depth==M){
            for(int val : basket){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0;i<N;i++){
            if(!flag[i]){
                flag[i] = true;
                basket[depth] = result[i];
                dfs(depth+1);
                flag[i] = false;
            }
        }
    }
}
