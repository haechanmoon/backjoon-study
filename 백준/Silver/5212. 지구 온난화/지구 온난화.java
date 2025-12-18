/*
와 이런문제 진짜 어려운거같아 항상보면. grid문제. 이차원배열이용해서 푸는문제들.
흠. 이런건 진짜 어떻게풀어야할 지 솔직히 좀 어렵긴하다.
검사로직을 짜면되긴해. 깃발꽂아넣고. 뭐 그런거 관리하면 되지 않나? 싶다.
한번 풀어볼까?이거 충분히 할 수 있을것같긴한데.
일단 배열생성하고
본판. 깃발. 상하좌우 검사로직. 이렇게 하면 될거같은데?하나씩 증가해가면서 ㅇㅇ
그리고 마지막에는 stringbuilder로 꽂아넣으면될것같다.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        char[][] newMap = new char[R][C];

        for(int i = 0;i<R;i++){
            String line = br.readLine();
            for(int j = 0 ; j<C;j++){
                map[i][j] = line.charAt(j);
                newMap[i][j] = '.';
            }
        }

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        int minR = R, maxR = -1;
        int minC = C, maxC = -1;

        for(int r = 0;r<R;r++){
            for(int c = 0;c<C;c++){
                if(map[r][c] =='X'){
                    int seaCount = 0;

                    for(int d=0;d<4;d++){
                        int nr = r+dr[d];
                        int nc = c+dc[d];

                        if(nr<0||nr>=R||nc<0||nc>=C){
                            seaCount++;
                        }
                        else if(map[nr][nc] =='.'){
                            seaCount++;
                        }
                    }

                    if(seaCount<3){
                        newMap[r][c] = 'X';

                        minR = Math.min(minR,r);
                        maxR = Math.max(maxR,r);
                        minC = Math.min(minC,c);
                        maxC = Math.max(maxC,c);
                    }
                }
            }


        }
        if(maxR==-1){

        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = minR;i<=maxR;i++){
                for(int j = minC;j<=maxC;j++){
                    sb.append(newMap[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }
}
