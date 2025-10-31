/*
이건 어떻게 구하는걸까...일단. 이 값보다 최대한 가까운수를 빼고.빼고.빼고.빼고. 무한반복아닌가?
그거를 count 하면 되는거 아닐까?
오름차순으로 입력되기 때문에. 따로 배열을 정렬 할 필요도 없긴할듯?
coin[i] while로 돌려서 만약 크면 빼!
while로 한번 더 감싸! 그럼 될 거 같은데?
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (coin[i] <= K) {
                count += (K / coin[i]);
                K = K % coin[i];
            }

            if (K == 0) {
                break;
            }
        }

        System.out.println(count);
    }
}
