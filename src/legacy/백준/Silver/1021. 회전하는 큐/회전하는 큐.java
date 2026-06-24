import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인덱스를 찾기 위해 LinkedList 사용 (Deque 인터페이스 구현체)
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int target : targets) {
            int targetIdx = deque.indexOf(target); // 뽑아낼 숫자의 현재 위치
            int halfIdx = deque.size() / 2;       // 큐의 절반 위치

            // 1. 타겟이 큐의 앞쪽 절반에 있다면 -> 왼쪽으로 회전 (2번 연산)
            if (targetIdx <= halfIdx) {
                for (int j = 0; j < targetIdx; j++) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            } 
            // 2. 타겟이 큐의 뒤쪽 절반에 있다면 -> 오른쪽으로 회전 (3번 연산)
            else {
                for (int j = 0; j < deque.size() - targetIdx; j++) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
            // 회전이 끝났으면 맨 앞의 타겟을 뽑아냄 (1번 연산)
            deque.pollFirst();
        }

        System.out.println(count);
    }
}