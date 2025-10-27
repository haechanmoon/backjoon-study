/*
이 문제는 굉장히 쉬운것같은데?
일단 N만큼 숫자들 받아서. ArrayList에 넣고 sort.해.
아래쪽 15%, 위쪽 15% 짤라서.
그걸로 average내면 되는거 아녀?
근데 올림하는법. 알아야할 것 같고.
자르는법을 알았으면 하는데 그건 모르겠네.

아! Math.round를 쓰면 되는구나! 근데 형변환을 위해 (Double)을 쓰는것이 중요!
범위를 [trim-N-trim] 까지!
 */

import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(scores);
        int trimCount = (int) Math.round((double) N * 0.15);

        int sum = 0;
        for (int i = trimCount; i < N - trimCount; i++) {
            sum += scores[i];
        }

        int remainingCount = N - 2 * trimCount;
        double average = (double) sum / remainingCount;
        int finalScore = (int) Math.round(average);

        System.out.println(finalScore);
    }
}