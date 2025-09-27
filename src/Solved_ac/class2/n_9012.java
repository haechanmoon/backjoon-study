package Solved_ac.class2;

import java.util.Scanner;
import java.util.Stack;

public class n_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String line = sc.next(); // 1. for문 안에서 각 줄을 새로 읽기

            boolean isVPS = true; // 3. 매번 flag를 true로 초기화
            stack.clear(); // 스택도 비워주기

            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);

                if (c == '(') {
                    stack.push(c);
                } else { // ')'인 경우
                    if (stack.isEmpty()) {
                        isVPS = false;
                        break;
                    }
                    stack.pop(); // 2. pop()은 한 번만!
                }
            }

            if (!stack.isEmpty()) {
                isVPS = false;
            }

            if (isVPS) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}