package Solved_ac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_1018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 전체 보드를 2차원 배열에 입력받기
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minRepaints = 64; // 다시 칠해야 하는 정사각형의 최소 개수 (최대값은 8x8=64)

        // 2. 8x8로 자를 수 있는 모든 시작점을 순회
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                // 3. 현재 8x8 보드를 검사해서 다시 칠할 개수를 구함
                int currentRepaints = getRepaintCount(board, i, j);

                // 4. 지금까지 찾은 최소값과 비교해서 더 작으면 업데이트
                if (currentRepaints < minRepaints) {
                    minRepaints = currentRepaints;
                }
            }
        }
        System.out.println(minRepaints);
    }

    /**
     * (startRow, startCol)에서 시작하는 8x8 체스판을 검사하여
     * 다시 칠해야 하는 최소 개수를 반환하는 함수
     */
    public static int getRepaintCount(char[][] board, int startRow, int startCol) {
        int countW = 0; // 맨 왼쪽 위가 'W'로 시작할 경우, 다시 칠할 개수
        int countB = 0; // 맨 왼쪽 위가 'B'로 시작할 경우, 다시 칠할 개수

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char currentSquare = board[startRow + i][startCol + j];

                // 체스판의 칸은 행(i)과 열(j)의 합이 짝수인지 홀수인지에 따라 색이 결정됩니다.
                if ((i + j) % 2 == 0) { // 짝수번째 칸 (맨 왼쪽 위 칸과 색이 같아야 함)
                    //  'W'로 시작하는 체스판과 비교
                    if (currentSquare != 'W') {
                        countW++; // 'W'가 아니면 칠해야 함
                    }
                    //  'B'로 시작하는 체스판과 비교
                    if (currentSquare != 'B') {
                        countB++;
                    }
                } else { // 홀수번째 칸 (맨 왼쪽 위 칸과 색이 달라야 함)
                    //  'W'로 시작하는 체스판과 비교
                    if (currentSquare != 'B') {
                        countW++;
                    }
                    //  'B'로 시작하는 체스판과 비교
                    if (currentSquare != 'W') {
                        countB++;
                    }
                }
            }
        }
        // 두 경우 중 더 적게 칠하는 횟수를 반환
        return Math.min(countW, countB);
    }
}