/*
Z문제라...이거를 어떻게 풀어야할까나~~!!
일단 함수를 하나 만들어야할 것 같은데?
12
34 로 돌아가는 함수. 이거를 쪼갤 수 있을 때 까지 쪼갠다음에 적용하는 큰 그림이 보이는데..
재귀함수야. 일단은. 어떻게 해볼까나
일단. dx dy 순회하는거 만들어야지.
dx[] = [0,1,0,1]
dy[] = [0,0,1,1]
이렇게 해놓고 반복
array[i] = dx[i],dy[i]
일단여기까지는 맞고
이거 근데 뭔가 dfs느낌이 팍나는데?
스택에 넣고
최근꺼 거내면서 저거 돌리는거야.
재귀함수냐,,,dfs냐...그것이 문제로다.일단  재귀한번짜볼까
근데 재귀가 더 맞는거같긴하다
함수이름 Z 매개변수 (?)
범위가 이제 int[y][x]이면
[0~y/2,0~x/2],[0~y/2,x/2~x][y/2~y,0~x/2][y/2~y,x/2~x]이렇게. 4개. 오케이? 할 수 있지.
범위를 재귀로 나누고. 단 y,x >=2 이여야함.
그리고, 또 순회하는거. 기능을 2개로 나눠야하나? 어쩃든.
순회하는건 위에꺼하면될것같고. 암암. 습 근데 이거 갑자기 든 생각인데 dfs가 더맞는거같네.
STACK에 둘러쌓여서 깊은거까지 하는거 보니까.
Stack에 범위나누는거랑 순회하는거 함수 같이 넣어놓으면 꺼내면서 반복하는거 아니여? 아 잠시만 스택에 그럼 순서를 어떻게 넣어야하냐.
젤마지막에 넣는거 먼저실행되는건데. Z방향 거꾸로 가야하나.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int findz(int row, int column, int size) {
        if (size == 1) {
            return 0;
        }
        int newSize = size >> 1;
        int squareSize = newSize * newSize;
        if (row < newSize && column < newSize) {
           return findz(row, column, newSize);
        } else if (row < newSize && column >= newSize) {
           return squareSize + findz(row, column - newSize, newSize);
        } else if (row >= newSize && column < newSize) {
            return squareSize*2 +findz(row-newSize, column, newSize);
        } else {
            return squareSize*3 + findz(row-newSize, column-newSize, newSize);
        }
    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int size = 1 << N;
        System.out.print(findz(row,column,size));
    }
}
