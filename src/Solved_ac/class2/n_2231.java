/*package Solved_ac.class2;

import java.util.Scanner;

public class n_2231 {
    public static void main(String[] args) {
        /*
        어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
        어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
        예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다.
        따라서 245는 256의 생성자가 된다.
        물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다.
        반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
        자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = N; //복제본 (자릿수 구하기 위함)
        int num = 0; //자릿수
        while (T != 0){
            T = T/10;
            num++;
        }  //자릿수 구현 완료.
        T = N;
        int[] P =  new int[num];
        for (int i = 0; i < num; i++){
            P[i] = T%10;
            T = T/10;
        } //배열로 각 자리수 생성 완료


        }

        int total=0;
        for (int i = 0; i < num; i++){
            total += P[i];
        } //각 자리수 덧셈 완료

        */

         /*그니까. 가장 작은 생성자를 만들라는거아냐?
         141 분해합은 147(141+1+4+1) 이거잖아.
         와 이거 쉽지 않네.
         이거 어떻게 풀어나가야 되나?
         147 생성자 구해볼까 그럼. 해보면 되지. 내가 어떻게 생각하느냐 그대로 적어보는거야.
         141 147-6
         139 147-8 아! 깨달았다. 147-1부터 쭉 해. 그다음에 나온 각 자리 숫자 합이 -T랑 같아야하는거야.
         이해함?
         그래서 그냥 T를 그냥 N까지 둬도 될것같은데... 문제 정답은 맞을듯.
         일단 몇자리수인지까지는 구현이 완료 되었습니다.

         야 근데이거 그냥 이렇게 하지말고
         일단 쭉쭉 내려가다가 4545 있어. 4544 해봐. 안되잖아!
         이렇게 쭉쭉 내려가다가 자기 자신이랑 각자리 수 합 나온거 맞는거 찾으면 되는거 아니야? 그냥 0까지?
         근데 만약 147이렇게있으면 이걸 {1,4,7} 하고싶은데 어떻게 해야할까?
         147%10 = 7 147/10 = 14
         14%10 = 4 14/10 = 0
         1%10 = 1  이런느낌으로 해야되는구나.
          *

    }
}
*/

package Solved_ac.class2;

import java.util.Scanner;

public class n_2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int j = 1;j<=N;j++) {
            int T = j; //복제본 (자릿수 구하기 위함)
            int num = 0; //자릿수
            while (T != 0) {
                T = T / 10;
                num++;
            }  //자릿수 구현 완료.
            T = j;
            int[] P = new int[num];
            for (int i = 0; i < num; i++) {
                P[i] = T % 10;
                T = T / 10;
            } //배열로 각 자리수 생성 완료
            int total = 0;
            for (int i = 0; i < num; i++) {
                total = total + P[i];
            }
            int realtotal = total+j;
            if(realtotal == N){
                System.out.println(j);
                break;
            }
            if(j==N){
                System.out.println(0);
                break;
            }
        }
    }
}