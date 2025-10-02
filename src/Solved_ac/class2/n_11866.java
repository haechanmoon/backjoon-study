package Solved_ac.class2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n_11866 {
    public static void main(String[] args) {
        /*
        1. 링크드리스트가 맞다. 근데 처음과 끝을 연결해야하는데.음.
        2. (7,3) 이면 제거하고 이제 그 다음 3번째. 이렇게 가는구나..ㅇㅋㅇㅋ
        3. 일단 Queue를 만들고. 뒤랑 앞이랑 구분을 해준 뒤. 거기서 이제 판가름이 나는거야.
        4. 어떻게하면 좋은 시스템을 만들 수 있을까...
        5. 근데 이거 계속 반복하면 결국엔 만들어지지 않을까? 한번해보자. 앞뒤만 계속 바꿔나가주면 될것같음.
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < K-1; i++) {
                q.add(q.poll());
            }
            if (j<=N-2) {
                sb.append(q.poll()).append(", ");
            }else{
                sb.append(q.poll());
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
