/*
이거 딱봐도 스택 쓰는 문제인데? 맞지않나?
근데 검사기능이 필요할 것 같다. 그니까 이게 계산을 잘해야해.
스택을 잘 써야한단 말이야.
안에 올바른 괄호가 있다면 걔도 정상으로 인정해주면댐. 오케이? ㄱㄱ
하기전에 잠깐 설계좀 해야할 것 같긴한데.
Stack만들고 거기에 일단 하나씩 넣어.
넣다가 이제 언제 꺼내냐. )나 ]가 나올때 짝이 맞으면 된다 이거야.
]가 나올때는안에있는걸 꺼내봐. 그때 [가 있으면 ok. pass
)가 나올떄 pop해야해.  그때 (가 있으면 ok pass.
자. 가보자.
 */

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int temp = 1;

        for(int i =0 ; i<input.length();i++){
            char cur = input.charAt(i);
            if(cur=='('){
                stack.push(cur);
                temp *=2;
            }else if(cur=='['){
                stack.push(cur);
                temp *=3;
            }

            else if(cur==')'){
                if(stack.isEmpty()||stack.peek()!='('){
                    System.out.println(0);
                    return;
                }
                if(input.charAt(i-1)=='('){
                    result += temp;
                }
                stack.pop();
                temp/=2;
            }

            else if(cur==']'){
                if(stack.isEmpty()||stack.peek()!='['){
                    System.out.println(0);
                    return;
                }
                if(input.charAt(i-1)=='['){
                    result += temp;
                }
                stack.pop();
                temp /=3;
            }
        }
        if(!stack.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(result);
        }
    }
}