/*
1부터 N까지 쭉 숫자가 있는데 그게 몇 개 빠진거잖아. 그럼 뭐 어떻게 해야할까?
어디서부터 고쳐먹어야할까
최소를 구하는거잖아.Logic 구현할 때 굉장히 중요하단말씀이지. . .
999909뭐 이렇게 있다고 쳐. 그럼 이거를 어떻게 활용해야하지?
최소이기때문에, 이렇게 가야해
9 19 29 39 40 49 이렇게 생각해야하지않겠어.? 이거를 내가 어떻게 생각해냈을까?
첫숫자를 1이랑 가장 가까운수로 정해야해. 그다음나오는숫자는 첫째와가장 가까운숫자. 이렇게 계산을해야할것같은데. 1부터니까.
이게 사람은 금방 알아차릴 수 있는데 컴퓨터는 그게아니기때문에 진짜 컴퓨팅적 사고를 거쳐야하네. 하~~힘드누!
변수를 잘 설정하는게 좋을 것 같다.
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int ptr = 0;
        int base = 0;

        while(base++<30000){
            String tmp = String.valueOf(base);

            for(int i = 0;i<tmp.length();i++){
                if(tmp.charAt(i)==input.charAt(ptr)){
                    ptr++;
                }

                if(ptr ==input.length()){
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}