//이건 제가 한거 아닙니다.
package Solved_ac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_9012_best {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb.append(solve(br.readLine())).append('\n');
        }
        System.out.println(sb);
    }

    public static String solve(String s) {
        int count = 0; // 스택 역할을 할 정수 카운터

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++; // 여는 괄호면 +1 (push)
            } else { // 닫는 괄호면
                if (count == 0) { // 뺄 괄호가 없으면 (pop할 게 없으면)
                    return "NO";
                }
                count--; // -1 (pop)
            }
        }

        if (count == 0) { // 모든 과정 후 짝이 맞으면
            return "YES";
        } else { // 여는 괄호가 더 많으면
            return "NO";
        }
    }
}