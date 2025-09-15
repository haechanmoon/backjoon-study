package Solved_ac.class2;

import java.util.Scanner;
import java.util.Arrays;

public class n_1978 {
    public static void main(String[] args) {
        /*소수찾기! 근데 소수는 어떻게 찾는거냐..,,하 어렵겠구만.
        일단.! N개의수가 주어지잖아? 거기서 제일 큰거를 골라. 그거를 /2하면
        자 알거같아. 일단 29가 제일 크다고 생각해. 일단 N개의 수 중에 짝수는 다 걸러.
        그럼 14가 나오잖아. 1부터 14까지 모든 수에다가 %붙혀보는거야. 만약 거기서 0이 나왔따? 그럼 걔는 탈락.
        이해됐지?
        이런느낌으로 하면 될것같은데? 코드를 한번 제대로 짜볼까 성취감 ㄹㅈㄷ일듯.. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T =  new int[N];
        for(int i = 0; i < N; i++){
            T[i] = sc.nextInt();
        }

        int total = N;
        Arrays.sort(T);//자 여기까지 이쁘게 입력 받았어. 정렬까지 됐어. 이제 어떡할래?

        /* 첫번째 T[0]. 얘를 int K = T[0]/2 해서 2부터 K까지 해봐. 거기서 만약 0이 나왔다? 그럼 total--.
        이런식으로 짜면 되지 않을까? 그럼 K도 배열형태로 나타내야되나? 오!.
        마지막은 그럼 T[N-1]이 되겠네.
        */
        int[] k = new int[N];
        for (int j = 0; j < N; j++){
            // 1. 예외 처리: 1은 소수가 아님
            if (T[0] == 1) {
                total--;
                continue; // 소수가 아니므로 다음 숫자로 넘어감
            }

            k[j] = T[j]/2;
            int p = k[j];
            for (int i = 2; i <= p; i++){
                if(T[j]%i==0){
                    total--;
                    break;
                }
            }
        }

        System.out.println(total);




    }
}



/* Gemini가 알려준 개선된 코드! 제곱근을 이용하면 더 나은 코드가 된다!
import java.util.Scanner;

public class n_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int primeCount = 0; // 소수의 개수를 직접 세는 방식으로 변경 (더 직관적)

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            boolean isPrime = true; // 일단 소수라고 가정하고 시작

            // 1. 예외 처리: 1은 소수가 아님
            if (num == 1) {
                continue; // 소수가 아니므로 다음 숫자로 넘어감
            }

            // 2. 2부터 자기 자신 전까지 나누어보며 소수인지 판별
            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    isPrime = false; // 나누어지는 수가 있으면 소수가 아님
                    break;           // 더 이상 검사할 필요가 없으므로 반복문 탈출!
                }
            }

            // 3. 반복문이 끝난 후에도 isPrime이 true라면 소수임
            if (isPrime) {
                primeCount++;
            }
        }
        System.out.println(primeCount);
    }
}

 */