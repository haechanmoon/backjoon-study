package woowacote.m_07.d_0704;

/*
거의 소수 구하기.
1. B의 제곱근 이하의 가장 큰 소수 C를 구해본다.
2. A부터 C까지의 소수를 구해본다.
3. 그 소수들이 B를 넘 지 않게 N개가 몇개가 들어갈 수 있는지 Count를 ++ 한다. 끝!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_1456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int limit = (int) Math.sqrt(B);
        boolean[] arr = new boolean[limit + 1];
        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i <= limit; i++) {
            if (!arr[i]) {
                for (long j = (long) i * i; j <= limit; j += i) {
                    arr[(int) j] = true;
                }
            }
        }
        int count = 0;

        for (int i = 2; i <= limit; i++) {
            if (!arr[i]) {
                long prime = i;
                long temp = prime;

                while (temp <= B / prime) {
                    temp = temp * prime;
                    if (temp >= A) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
