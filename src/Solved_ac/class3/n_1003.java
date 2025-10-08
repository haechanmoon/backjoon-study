package Solved_ac.class3;

/*이건 뭐 어떻게 하라는거지?
일단 피보나치 수열을 입력해서 print(0)할때마다 count++
근데 이거 그거잖아. 시간이 0.25초밖에안줌.
그래서 이걸 어떻게풀어나가야할까...
*/

import java.io.*;

public class n_1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[] zeros = new int[41];
        int[] ones = new int[41];
        zeros[0] = 1;
        ones[0] = 0;
        zeros[1] = 0;
        ones[1] = 1;
        for (int i = 2; i < 41; i++) {
            zeros[i] = zeros[i - 1] + zeros[i - 2];
            ones[i] = ones[i - 1] + ones[i - 2];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(zeros[N]).append(" ").append(ones[N]).append("\n");
        }
        System.out.print(sb);


    }

}
