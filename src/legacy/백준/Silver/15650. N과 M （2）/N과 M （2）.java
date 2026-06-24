/*
흠...알고리즘 분류봤는데 백트래킹이네. 이거는 처음 구현해 보는건데 할 수 있겠지?
자. 어디서부터 해야할까?
일단 필요한거.
자연수 수열 그리고 몇개 뽑을지.
이정도 있으면 될 것 같은데?한번해볼까?
 */


import java.util.Scanner;

public class Main {
    private static int N,M;
    private static int[] combination;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        combination = new int[M];

        dfs(1,0);
        System.out.print(sb);
    }

    public static void dfs(int start, int depth){
        if(depth == M){
            for(int val : combination){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start ; i<=N;i++){
            combination[depth] = i;
            dfs(i+1, depth +1);

        }

    }
}