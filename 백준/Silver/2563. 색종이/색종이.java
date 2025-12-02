/*
색종이 이차원배열문제.
이거는 좀 할 만 하지 않나? 전체 사각형에서 겹친부분을 빼면 되는거 아니교
생각보다 할만하지 않을지도..?
1. 사각형 총 넓이 계산
2. 겹치는부분 계산.
3. 범위를 와 근데 이거 3개 겹치는것도 생각을 해야하는부분아닌가?
4. 색칠하는거 가장 쉬운게 뭐야 --> isVisited이거아녀? 그게 몇개인가를 빼는게 정배.
5. 일단 함수를 만들어서 채워 넣을 수도 있겠어!
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final boolean[][] canvas = new boolean[100][100];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = N*100;

        for(int i =0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            count = paint(count,length,height);
        }

        System.out.print(count);

    }

    public static int paint(int count, int length, int height){
        for(int i = 0;i<10;i++){
            for(int j =0;j<10;j++){
                if(canvas[height+i][length+j]){
                    count--;
                }else{
                    canvas[height+i][length+j] = true;
                }
            }
        }
        return count;
    }
}
