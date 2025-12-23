/*
자!~!이건 어떻게 푸는건지 한번 볼까나!!~
그니까 이건 배열을 입력하는건데.
각자 짝을 갖고있네.
int[][] 가 숫자만 바꾼게 서로 짝이다. 그 짝들을 N/2개를 뽑아. 그거의 최소를 구하는거야.
이거는 아마 부루트 포스가 답이 아닐까 하는데? 다 구해보는게 아마 답이 될 것 같은데. ?
int[0][1],int[1][0] 부터 시작해서 끝까지 한번 해보는거야.
백트래킹도 아마 사용될 것 같은데? 그럼 훨씬 빨라지고 좋은 코드가 될 것 같아.
아니 백트래킹 생각하는거 확실히 빡세긴하네.
이 문제 템플릿처럼 외워두면 나중에 나오는 백트래킹 문제 쉽게 먹을 수 있을 듯 . 
for문안에 재귀함수 들어가는거 근데 좀 고역이네 생각할게 너무많아서. 
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] visit;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N];

        for(int i = 0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.print(minDiff);
    }

    private static void dfs(int idx, int count){
        if(count ==N/2){
            calculateDiff();
            return;
        }

        for(int i = idx;i<N;i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(i+1,count+1);
                visit[i] = false;
            }
        }
    }

    private static void calculateDiff(){
        int startTeam = 0;
        int linkTeam = 0;

        for(int i = 0;i<N;i++){
            for(int j = i+1;j<N;j++){
                if(visit[i]&&visit[j]){
                    startTeam += map[i][j];
                    startTeam += map[j][i];
                }
                else if(!visit[i]&&!visit[j]){
                    linkTeam += map[i][j];
                    linkTeam += map[j][i];
                }
            }
        }

        int val = Math.abs(startTeam-linkTeam);
        if(val ==0){
            System.out.println(0);
            System.exit(0);
        }
        minDiff = Math.min(val,minDiff);
    }
}
