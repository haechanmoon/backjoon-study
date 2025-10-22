/*
알고리즘 좀 짜봐야될 것 같은데.
666이 들어가야한다라...
이거 내가 7번째 수 6166인거 어케알음? 자. 알고리즘 보면 5666다음에 6166인거 어케 알았냐 하믄
그냥 1부터 쭉 올라가서 6세게인거 만족하는 수 고르면 되는 거 아님?
그거를 어떻게 알지..while n%10 n/10 이 0이 될 때까지 하면 되는 거 아니냐? 만약 6이면 count++해서 count3이면 ok그거야.
그러면 result ++ 하고. 이렇게 하면 잘 풀릴 수 있을 것 같은데...
됐다.해보자.

아@ 잠시만. 다시 짜보자.
666이 어떻게 6이 3개인지.
1666대상으로. 처음 10나머지 6  10나누기 10나머지 6 10나누기 10나머지 6

 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 0;
        int num = 666;

        while (true) {

            String numStr = String.valueOf(num);


            if (numStr.contains("666")) {
                count++;
            }

            if (count == N) {
                System.out.println(num);
                break;
            }

            num++;
        }
        sc.close();
    }
}