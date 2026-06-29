package woowacote.m_06.d_0629;

/*
자. 이거는 딱 보아하니 동전의 종류를 극한으로 사용하여 하는거임. 그리디의 뜻이 뭘까? 탐욕 이런건데.
흠. 그니까. 책에서 설명하는 거는 일단 첫번째가 해를 구 하고 두번째가 그거를 문제 적용을 해 보고 세번째가 해를 검정 하는 거야
 다시. 해를 선택하고 그 다음에 그 문제 제약 조건에 적절한지 적절성 검사를 해주고 그 다음에 검사를 하는 거야. 이게 계속 반복이 되는 건데.
 응, 일단 이거 동전 문제잖아 동전을 큰 거를 많이 쓰고 작은 거를 쪼개 써서 최대한 큰 수의 종류를 많이 쓰고, 그렇게 해야 동전에 개수가 적어 질 거 아냐
 이거를 어떻게 풀어야 되냐 고민이 되는 군 자 그럼 1번 해 보자
 자 나는 이걸 어떻게 풀 거냐면 배열을 만들 것 같아
 그래서 일단은 동전 종류에 큰 금액 부터 첫 번째 배열에 넣어서 그거를 계속 넣어 보는 거야 예를들어 100원 단위 동전 50원 단위 동전 10원 단위 동전 이렇게 치면은
 562 원을 만들기 위해서는 100 원짜리를 5번 넣고 여섯 여섯 개는 안 되잖아 그러니까 일단 다섯 개까지 하고 거기다가 50원 넣을 수 있잖아 50원 넣고 두 개는 안 되잖아
 그러니까 50원 하나 20 원짜리 하나 일 원짜리 두개 뭐 이렇게 하는 거 아닌가 근데 이게 책에서 말한 뭐해를 선택하고 문제 제약 조건의 적절한 지적적 절상 범죄를 하고
 그 다음에 해를 검사 하는 건데 그것이 무엇을 의미하는지는 잘 모르겠어
 그러니까 일단은 동전 종류를 하나의 배열로 만들고 이제 while문으로 돌리는 거야.
 그래서 그 금액이 초과 하지 않을 때까지 계속 넣는 거지 그렇게 하면 알고리즘 돌아갈 거 같은 데 하나 문제가 있어
 시간이 일초란 말이지 그렇기 때문에 시간 복잡도를 1번 생각을 해 봐야 돼 이게 배열을 첨부터끝까지 다 노는 거니까 와 일문도 들어 가잖아. 그러면은 적어도.
 왜 엔 제곱은 될 거 같은 데 종료가 열개이고 금액이 일 억이야 동전 열 개라서 해볼만 한 것 같기도 한데 왜냐면은 어차피 100 이니까 1초 충분한 거 같은 데
 그러면은 그렇게 1번 풀어 봐야겠다

 수도코드

 동전개수 N , 금액 K 받음.
 동전종류 뒤에서부터 받음 크기는 N.
 result변수 하나 만들어줘.
 그다음에 그 배열 처음부터 일단 무작정 넣어봐. for문안에 while문 들어가 있는 느낌으로.
 그렇게 하면 충분히 풀 수 있을 것 같은데?
 최종은 result 풀어버림.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int result = 0;
        for (int i = 0; i < N; i++) {
            arr[N - i - 1] = Integer.parseInt(br.readLine());
        }

        for (int coin : arr) {
            if (coin <= K) {
                result += (K / coin); // 나눗셈으로 한번에 몫을 더함.
                K = K % coin; // 여기가 키포인트네.
            }
            if (K == 0) {
                break;
            }  // 여기가 해 검증
        }
        System.out.println(result);
    }
}
