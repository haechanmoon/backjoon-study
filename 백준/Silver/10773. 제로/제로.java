/*
야~~~~이거 스택이잖아!!!
 */

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> list = new Stack<>();

        int K = Integer.parseInt(br.readLine());

        int num = Integer.parseInt(br.readLine());
        list.push(num);
        for (int i = 0; i < K - 1; i++) {
            int num2 = Integer.parseInt(br.readLine());
            if (num2 == 0) {
                list.pop();
            } else {
                list.push(num2);
            }
        }
        int[] addStack = new int[list.size()];
        int sum = 0;
        for (int t : addStack) {
            t = list.pop();
            sum += t;
        }
        System.out.print(sum);
    }
}
