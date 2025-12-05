/*
이거 규칙 뭐 별거 없는거같은데!
기능구현 정의
1. [x] 사용자 문자열 받기
2. [ ] 태그 확인 기능
3. [ ] 문자 뒤집기 기능 (공백을 기준으로) substring아마 써야하나?
4. [ ] 출력

Stack을 활용한! 아주 재밌는 문제가 됐군요. 한참 찾았습니다.
이거 근데 쉽진 않군요.
*/

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        String input = InputView.input();
        String result = WordReverser.reverse(input);
        OutputView.print(result);

    }
}

class WordReverser{
    private static final StringBuilder sb = new StringBuilder();
    private static final Stack<Character> stack = new Stack<>();
    private static boolean isTag = false;
    
    public static String reverse(String input){
        sb.setLength(0);
        stack.clear();
        isTag = false;
        
        for(int i =0;i<input.length();i++){
            char ch = input.charAt(i);
            
            if(tryHandleTagStart(ch)) continue;
            if(tryHandleTagEnd(ch)) continue;
            if(tryHandleInsideTag(ch)) continue;
            if(tryHandleSpace(ch)) continue;
            
            stack.push(ch);            
        }
        
        flushStack();
        return sb.toString();
        
    }
    
    private static boolean tryHandleTagStart(char ch){
        if(ch=='<'){
            flushStack();
            isTag = true;
            sb.append(ch);
            return true;
        }
        return false;
    }
    
    private static boolean tryHandleTagEnd(char ch){
        if(ch=='>'){
            isTag = false;
            sb.append(ch);
            return true;
        }
        return false;
    }
    
    private static boolean tryHandleInsideTag(char ch){
        if(isTag){
            sb.append(ch);
            return true;
        }
        return false;
    }
    
    private static boolean tryHandleSpace(char ch){
        if(ch==' '){
            flushStack();
            sb.append(ch);
            return true;
        }
        return false;
    }
    
    private static void flushStack(){
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
    }
}

class InputView{
    public static String input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}

class OutputView{
    public static void print(String message){
        System.out.println(message);
    }
}