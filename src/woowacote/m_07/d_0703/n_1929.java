package woowacote.m_07.d_0703;

/*
소수구하기

이거는 배열을 이용하여 일단 쭉 나열한 다음에 그에 해당하는 배수들을 다 지움. 그걸 끝까지 반복하는거임.
근데 이거 제곱근까지만 하면 되는걸로 알고 있거든? 그걸로 해서 한번 해봅시다!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] isNotPrime = new boolean[M + 1];

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        int limit = (int) Math.sqrt(M);

        for (int i = 2; i <= limit; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= M; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = N; i <= M; i++) {
            if (!isNotPrime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}
