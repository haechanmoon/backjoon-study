package woowacote.d_0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class n_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int a = Math.abs(o1);
            int b = Math.abs(o2);

            if (a == b) {
                return o1 - o2;
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(priorityQueue.poll()).append("\n");
                }
            } else {
                priorityQueue.add(x);
            }
        }
        System.out.println(sb);

        // pq는 작은수부터 뽑아내는데, 이번 구현은 절댓값이 작은것부터 나와야한다..
        // 애초에 받을 때 리버스 해야하나? 이거 어떻게 정의하지? 우리가 사설 방 파서 해야하는데?
        // 현재 배열에서 que에 있는 절댓값 작은것부터 정의를 해줘야하네.
        // 1. 일단 받은 값들을 다 배열에 저장
        // 2. 0이 나오면 현재 queue에서 절댓값 가장 작은거 (절댓값 같으면 수 자체가 작은거부터)
        // 3. 이렇게 하면 되지 않을까?
        // 4. 사용자 정의 해야하는데. 이거 어떻게 하는거지?

    }
}
