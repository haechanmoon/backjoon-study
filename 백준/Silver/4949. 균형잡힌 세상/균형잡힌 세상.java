import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;


        while (!(line = br.readLine()).equals(".")) {
            sb.append(solve(line)).append('\n');
        }
        System.out.print(sb);
    }

    public static String solve(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            }
            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                }
                stack.pop();
            }
            else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}