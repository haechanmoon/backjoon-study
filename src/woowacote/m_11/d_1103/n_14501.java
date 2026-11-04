package woowacote.m_11.d_1103;

/*
DP로 푸는건데 이거 ㄹㅇ 너무 어려워.. 하. Top Down으로 풀어야해!
근데 내가 간과하고 있던 게 있다. 이거 sudo코드를 왜 안짜고 있었지? 이거 진짜 중요한 작업인 것 같은데...
D(점화식 배열 --> i ~ 퇴사일까지 벌 수 있는 최대 수입을 저장하기)
T(상담에 필요한 일 수 저장 배열)
P(상담을 완료했을 때 받는 수입 저장 배열)
for( N ) {
    T와 P 배열 입력받기
}
for(i->N~1까지 반복){
    if(i+T[i] > N+1){ --> 이게 진짜 하이라이트인 것 같은데 ...
        D[i] = i + 1 일 ~ 퇴사일에 벌 수 있는 최대 수입
    } else {
        D[i] = MAX(i+1일 ~ 퇴사일에 벌 수 있는 최대 수입과 i 번째 상담비용 + i번째 상담이 끝난 다음 날부터 퇴사일까지의 최대 수입)
    }
}
D[1] (1일부터 퇴사일까지 벌 수 있는 최대 수입) 출력하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] t = new int[N + 1];
        int[] p = new int[N + 1];
        int[] dp = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N; i >= 1; i--) {
            if (i + t[i] > N + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], dp[i + t[i]] + p[i]);
            }
        }
        System.out.println(dp[1]);
    }
}
