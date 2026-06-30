package woowacote.m_06.d_0629;

/*
와. 이거는 생각을 좀 해봐야되는 문제인것같은데? 이거 상당히 힘든데? 흠...어떻게 하는게 좋을까?
그니까 이 문제의 핵심은 일단. 작은거부터 계속 더해나가야한다는 점이야. 흠. 그러려면 도대체가 어떻게 생각해야하지.
작은거부터 더해나가서 최소값을 유지해나간다라...그럼 값을 바꿔줘야 하나 이런 생각이 일단 먼저 드는데?
그리고 이거 정렬을 계속하는게 좋지 않은것같아. 흠. 아아아아아 해답을 진짜 모르곘다.
아 ㅋㅋ 해답을 찾았다. 이거 우선순위 큐를 하는거네. 하. 이거를 근데 모르면 어떻게 풀어 ㅋㅋ
큐가 비었을 때 까지 while문 돌면서 계속 더해나가야해. 누적해서 쌓는거지. 근데 그런 규칙은 어떻게 만들지?
우선순위큐를 있잖아. 작은거부터 어떻게 설정하는거야? 아 뭐 PriorityQueue<>(Collections.reverseOrder()) 뭐 이런걸 쓴다더라.
자. 그럼 수도코드 작성해보자.
카드묶음ㅅ수 N 받고 일단 우선순위 큐에 다 때려박아. N번만큼 말이야.
그 다음에 2개를 poll해. 그리고 sum에 더해. 그다음에 sum을 다시 큐에 넣는 과정이야. 그게 queue가 1개이상일때까지! while문!
이거 구현은 그럼 금방 하겠는데? ㄱㄱ
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class n_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            que.add(Integer.parseInt(br.readLine()));
        }

        int total = 0;
        while (que.size() > 1) {
            int a = que.poll();
            int b = que.poll();
            int currentSum = a + b;
            total += currentSum;
            que.add(currentSum);
        }
        System.out.println(total);
    }
}
