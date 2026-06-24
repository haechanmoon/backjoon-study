package woowacote.m_05.d_0528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_11399 {


    // 1. 일단 n받고 배열하나 만든다.
    // 2. 일단 순서를 정렬한다. 이 때 버블정렬을 사용한다.
    // 2.5배열을 하나 더 만들어야한다.
    // 3. 그다음에 누적합을 사용한다. 이게 결과이다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int temp = 0;
        for (int i = 0; i < N; i++) {
            temp += arr[i];
            sorted[i] = temp;
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += sorted[i];
        }
        System.out.println(result);
    }
}
