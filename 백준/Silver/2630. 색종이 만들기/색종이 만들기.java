
/*
자 이건 어떻게 푸는지 한번 볼까~~~
1. N이 일단 정해져있음! 그래서 할 만 할지도?
2. 일단 칸을 나누는걸 어떻게 할까? 그걸 한번 생각해봐야해. 영역을 나누는거
3. 거기에 0이 있으면 한칸 더 나누고. 없으면 그냥 냅두고
4. 총 합이 얼마인지 구하는건 뭐 일도 아닐 수 있음!

구현할 리스트 생각해보자
1. N 입력받기
2. 값들 입력 받아
3. 칸들을 나눠
4. 같은색으로 채워지지 않은 것들 나눠!
4.5 재귀함수를 노려라!
5. 칸을 나눌 수 없을 때 까지.
6. 0묶음 몇개 1묶음 몇개 출력


 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int whiteColor = 0;
    static int blueColor = 0;
    static int[][] board;

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int i =0 ;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0;j<N;j++){
               board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0,0,N);
        sb.append(whiteColor).append("\n").append(blueColor);
        System.out.print(sb);
    }

    public static boolean isColorSame(int[][] board, int col, int row, int size){
        int firstColor = board[row][col]; //기준 색 정하기

        //전체 순회 및 비교
        for (int i = row; i<size+row; i++){
            for (int j = col;j<col+size;j++){
                if(board[i][j] != firstColor){
                    return false;
                }
            }
        }

        return true;


    }


    public static void solve(int row, int col, int size){
        //일단 isColorSame 불러와서 비교해보기
        if(isColorSame(board,col,row,size)){
            if(board[row][col] == 0){
                whiteColor++;
            }else{
                blueColor++;
            }
            return;
        }

        //색이 섞이지 않았다면?
        int newSize = size/2;
        solve(row, col, newSize);
        solve(row, col+newSize, newSize);
        solve(row+newSize, col, newSize);
        solve(row+newSize, col+newSize, newSize);
    }

}
