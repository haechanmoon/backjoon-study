/*
아니 이건 뭔 문제냐?아주 참신한 문제도 만들어놓으셨네.
근데 이런건 진짜 어떻게 짜야할 지 감이 안오네 ㅋㅋ
설계부터 들어가보자!!
일단 이차원배열을만들어야하는건 맞는것같은데.
이동할 수 받고
근데 방향 바꾸는게 너무 어렵네. R이면 오른쪽보고. L이면 왼쪽으로 돌고.
F는 그나마 알겠는데. . . ㅎ.
이거 근데 진짜 어떻게 푸는냐. 흠..
F가 나오기 전까지 방향을 설정하는거니까. 지금 내가 어디를 보고있냐가 중요한데.
그거를 어떻게 하느냐 이말이지.
이 문제 유형은 진짜 많이 나오는 것 같아. 그냥 외워버리는게 좋겠어.
어짜피 학습하는 입장이기 때문에 외워서 나쁠 건 없음. 외우고 이해는게 
더 빠를 수도 있는거야. 솔직히 이런거 많이 보다보면 외워야지. 
 */

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String command = br.readLine();

        char[][] map = new char[101][101];
        for(char[] word : map){
            Arrays.fill(word,'#' );
        }

        int[] dr = {1,0,-1,0};
        int[] dc = {0,-1,0,1};

        int r = 50;
        int c = 50;
        int dir = 0;

        map[r][c] = '.';

        int minR = 50,maxR = 50;
        int minC = 50,maxC = 50;

        for(int i =0;i<N;i++){
            char cmd = command.charAt(i);

            if(cmd=='F'){
                r = r+dr[dir];
                c = c+dc[dir];

                map[r][c] = '.';

                minR = Math.min(minR,r);
                maxR = Math.max(maxR,r);
                minC = Math.min(minC,c);
                maxC = Math.max(maxC,c);
            }else if(cmd=='R'){
                dir = (dir+1)%4;
            }else if(cmd=='L'){
                dir = (dir+3)%4;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = minR;i<=maxR;i++){
            for(int j =minC;j<=maxC;j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }
}
