/*
소수 구하기 문제거든? 이거 진짜 쉽지 않은거야. 하. 어떻게 풀어야하는걸까.
일단 진짜 뭔가 DP냄새가 나긴 하거든? 근데 소수구하는게 그냥쉬운게 아니잖아 솔직히.
흠..어떤 원리가 있을까?일단. 짝수는 다 제거하면 될 것 같고. 3부터 시작해서 DP에 박아넣으면 되는거아닌가...
근데 N,M이 백만보다 작거나 같다는데..이거 괜찮겠지.? 흠. 아닌가. 일단 시간제한은 없긴한데.
음. 뭘쓰는걸까...소수는 근데 관련들이 없지 않나?일단 뭐 생각은 해볼 수 있으니
dp[i] i까지의 소수의 개수
음. 소수를 어떻게 찾는거지?
일단. 그 전까지 숫자를 다 나눠서 나머지가 0이 2개 되면 소수? 이렇게 푸는건가?
이게맞다고..?
이게 이렇게 되는거같은데.
일단. 3 5,7은 무조건 소수잖아. 그럼 그것들을이용해서. 찾는거야.
일단. 짝수는 다 빼고. 짝수는 다 빼야함. 귀찮아. 그리고 여태까지의 배열들로 다 나눠봐. 그럼에도 불구하고 없어? 이거는 소수 인정.
이런느낌으로 푸는게 아닐까?
소수를 그렇게 구하고 찐 배열에넣을때 몇번인지. 그거를 찾으면 될 것 같은데?
오케이 . 감잡았으.
아 이렇게 하는게 아니였네. 
에라토스테네스의 체 원리
이걸 이용하는거였어. 아니 근데 이거는 모르면 진짜 생각 디게 오래해야하는 문제인데. 
이런 도구도 있다는 걸 알았으니 다행!
 */
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2;i<=Math.sqrt(N);i++){
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                System.out.println(i);
            }
        }
    }
}
