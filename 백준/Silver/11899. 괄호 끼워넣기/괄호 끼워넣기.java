import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                stack.push(c);
            } else { 
                if (stack.isEmpty()) {
                    count++; 
                } else {
                    stack.pop(); 
                }
            }
        }
        System.out.println(count + stack.size());
    }
}