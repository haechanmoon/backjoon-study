package woowacote.m_07.d_0706;

/*
제곱이 아닌 수 찾기
제곱이 아닌 수를 어떻게 찾아야할까요? 1부터 10까지 제곱이 아닌 수를 찾는과정?
1,2,3,4(X),5,6,7,8(X),9(X),10 이거인데. 흠. 이거 근데 1이랑 10은 포함인가 보네. 오케이. 자. 해보자.
일단 이것들 보니까 소수의 제곱수들을 제외한 수들 같거든? 그니까 소수는 포함이야. 그니까
소수가 2,3,5,7 이 있잖아. 4,9,25,49 이것들이 아니라는 거지. 그니까 소수의 제곱수들을 파악하여 그것들의 배수들을
싹 제거를 해주는거야. 1조개를 일단 만든다음에 리팩토링 해야할 것 같은데 어떻게 생각해?
 */

import java.util.Scanner;

public class n_1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long M = sc.nextLong();
        boolean[] arr = new boolean[(int) (M - N + 1)];
        for (long i = 2; i * i < M; i++) {
            long pow = i * i;
            long start_index = N / pow;
            if (N % pow != 0) {
                start_index++;
            }
            for (long j = start_index; pow * j <= M; j++) {
                arr[(int) ((j * pow) - N)] = true;
            }
        }
        int count = 0;
        for (int i = 0; i <= M - N; i++) {
            if (!arr[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
