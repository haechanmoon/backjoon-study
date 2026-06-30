package woowacote.m_06.d_0630;

/*
자. 이거는 어떻게 하는거냐함을 한번 봅시다.
흠. 내가봤을 때는 이거 우선순위큐를 한번 더 쓰는게 맞는거같은데?
최댓값을 구하는거니까 말이야.. 흠...
일단 우선순위 큐를 반대로 돌리는거 있지 . 그거를 일단해.
3가지 케이스가 있을거야.
양수, 0, 음수
양수는 큰거끼리 곱하고 변수에 더해야하고.
0은 그냥 패스
음수는 음수끼리 곱하고 변수에 더해야해. 근데 이거 작은거끼리해야해. 이거는.
그리고 만약에 음수가 홀수개이다? 그럼 0이랑 곱해서 더해줘야지. 이게 그리디인가?
얼추 생각한 방향은 맞는것같은데? 그럼 이걸 범위를 어떻게 나눌까야.
queue 에 어떻게 놔야할 지 모르겠어. 흠. 어제 했던 거 있지? 그 반대로 놓는거 말이야.
아. 그리고 1도 따로 놔야한다. 1도 더해주면 더 좋잖아? 굳이 묶을 필요 없이 말이야. 흠. 한번 구현해볼까?
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class n_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plusQue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQue = new PriorityQueue<>();
        int one = 0;
        int zero = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a > 1) {
                plusQue.add(a);
            } else if (a < 0) {
                minusQue.add(a);
            } else if (a == 0) {
                zero++;
            } else {
                one++;
            }
        }

        while (plusQue.size() > 1) {
            int num1 = plusQue.poll();
            int num2 = plusQue.poll();

            sum += num1 * num2;
        }
        while (minusQue.size() > 1) {
            int num1 = minusQue.poll();
            int num2 = minusQue.poll();

            sum += num1 * num2;
        }

        if (minusQue.size() == 1) {
            if (zero > 0) {
                sum += minusQue.poll() * 0;
            } else {
                sum += minusQue.poll();
            }
        }

        if (plusQue.size() == 1) {
            sum += plusQue.poll();
        }
        sum += one;
        System.out.println(sum);
    }
}
