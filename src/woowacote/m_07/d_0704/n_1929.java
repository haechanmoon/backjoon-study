package woowacote.m_07.d_0704;

/*
소수구하기 - 에라토스테네스의 체를 이용하기. 이거를 이용해서 한번 다시 구해봅시다!
일단 인덱스 n+1을 이용하여 배열을 구한 뒤 N제곱 전까지 배열을 이용하여 구함.
다 지워주고 True/False처리를 해준다.
 */

import java.util.Scanner;

public class n_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[] arr = new boolean[M + 1];
        arr[0] = true;
        arr[1] = true;
        int a = (int) Math.sqrt(M);
        for (int i = 2; i <= a; i++) {
            if (!arr[i]) {
                for (int j = i * i; j <= M; j += i) {
                    arr[j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = N; i <= M; i++) {
            if (!arr[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
