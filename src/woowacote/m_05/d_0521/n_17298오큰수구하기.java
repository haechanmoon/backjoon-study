package woowacote.m_05.d_0521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class n_17298오큰수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[N];
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> myStack = new Stack<>();
        for (int i = 0; i < N; i++) {
            //스택이 비어있지 않고 현재 수열이 스택 top인덱스가 가르키는 수열보다 클 경우
            while (!myStack.isEmpty() && a[myStack.peek()] < a[i]) {
                answer[myStack.pop()] = a[i];
            }
            //여기에는 인덱스를 넣어줌. ㅇㅋ?
            myStack.push(i);
        }
        while (!myStack.empty()) {
            answer[myStack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }
}
