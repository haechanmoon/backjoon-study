/*
어떻게 풀 것인가.
자. Greedy? 일단 점화식도 생각해봤는데 그건 아닌 것 같다.
그냥 생각한대로해!
2배 2배 -1-1-1
2배 -1 2배 -1

이렇게 해서 생겨난거잖아!

그럼 Greedy가 맞는 방법인 것 같다.
최소값을 찾은 뒤 그 방법을 적용시키면 된다.
현재값  - 목표값 이 현재값*2 보다 크면 무조건 현재값*2 를 해주는게 좋다.
현재값 - 목표값이 현재값*2 보다 작으면 -1 *2를 탐색해보고 그 결과와 -1 -1 *2 탐색후 그 결과를 비교한다.
비교값중 더 가까운 놈을 선택하고 -1 +1 선택한다.
 */


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int MAX_POS = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.print(bfs(N, K));
    }


    public static int bfs(int N, int K) {
        Queue<Integer> que = new LinkedList<>();

        int[] time = new int[MAX_POS + 1]; //time = N에서 i까지 가는데 걸리는 최소 시간
        Arrays.fill(time, -1);

        que.add(N);
        time[N] = 0;
        //que랑 time은 따로임!

        while (!que.isEmpty()) {
            int currentPos = que.poll();
            if (currentPos == K) {
                return time[currentPos];
            }
            int[] nextPositions = {currentPos - 1, currentPos + 1, currentPos * 2};

            for (int nextPos : nextPositions) {
                if (nextPos >= 0 && nextPos <= MAX_POS) {
                    //2. 아직 방문하지 않은곳인가?( time[nextPos] = -1)
                    if (time[nextPos] == -1) {
                        time[nextPos] = time[currentPos] + 1; //시간 기록 (현재 시간 + 1초)
                        que.add(nextPos);
                    }
                }
            }
        }
        return -1;
    }

}
